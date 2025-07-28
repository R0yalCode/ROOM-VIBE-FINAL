package edu.unl.cc.roomvibe.controllers;

import edu.unl.cc.roomvibe.bussiness.services.ReservaService;
import edu.unl.cc.roomvibe.domain.common.Reserva;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Steeven Pardo, Juan Calopino, Royel Jima, Daniel Savedra
 * @version 1.0
 */

@Named
@ViewScoped
public class ReservaBean implements Serializable {

    @Inject
    private ReservaService reservaService;

    private String nombre;
    private String email;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String habitacion;
    private Integer personas;
    private List<Reserva> listaReservas;
    private List<String> habitacionesDisponibles;
    private String criterio;
    private Reserva reservaSeleccionada;

    @PostConstruct
    public void init() {
        listaReservas = reservaService.findAll();
        habitacionesDisponibles = Arrays.asList("Individual", "Doble", "Suite");

        String idParam = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("id");

        if (idParam != null && !idParam.isEmpty()) {
            try {
                Long id = Long.parseLong(idParam);
                reservaSeleccionada = reservaService.findById(id);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Error al cargar reserva",
                                "No se encontró la reserva con ID: " + idParam));
            }
        }
    }

    public List<String> getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public String redirigirEditar(Long id) {
        return "/security/reservaEdit.xhtml?id=" + id + "&faces-redirect=true";
    }

    public String editar() {
        try {
            if (reservaSeleccionada.getFechaEntrada() != null && reservaSeleccionada.getFechaSalida() != null &&
                    reservaSeleccionada.getFechaSalida().before(reservaSeleccionada.getFechaEntrada())) {

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Fechas inválidas", "La fecha de salida debe ser posterior a la de entrada."));
                return null;
            }

            reservaService.update(reservaSeleccionada);
            listaReservas = reservaService.findAll();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Reserva actualizada", "Cambios guardados correctamente."));

            return "/security/reservaList.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error al editar", e.getMessage()));
            e.printStackTrace();
            return null;
        }
    }

    public void reservar() {
        try {
            if (fechaEntrada != null && fechaSalida != null && fechaSalida.before(fechaEntrada)) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Fechas inválidas",
                                "La fecha de salida debe ser posterior a la de entrada."));
                return;
            }

            Reserva reserva = new Reserva();
            reserva.setNombre(nombre);
            reserva.setEmail(email);
            reserva.setFechaEntrada(fechaEntrada);
            reserva.setFechaSalida(fechaSalida);
            reserva.setTipoHabitacion(habitacion);
            reserva.setPersonas(personas);

            reservaService.save(reserva);
            listaReservas = reservaService.findAll();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Reserva registrada",
                            "¡Gracias por reservar en Room Vibe!"));

            System.out.println("Reserva creada: " + reserva);

            nombre = null;
            email = null;
            fechaEntrada = null;
            fechaSalida = null;
            habitacion = null;
            personas = null;

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error al guardar",
                            e.getMessage()));
            e.printStackTrace();
        }
    }

    public void buscar() {
        if (criterio == null || criterio.trim().isEmpty()) {
            listaReservas = reservaService.findAll();
        } else {
            listaReservas = reservaService.buscarPorCriterio(criterio);
        }
    }

    public void limpiar() {
        criterio = null;
        listaReservas = reservaService.findAll();
    }

    public void verDetalle(Reserva reserva) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Reserva seleccionada",
                        "Reserva de " + reserva.getNombre() + " para habitación " + reserva.getTipoHabitacion()));
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public ReservaService getReservaService() {
        return reservaService;
    }

    public void setReservaService(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public void setHabitacionesDisponibles(List<String> habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public Reserva getReservaSeleccionada() {
        return reservaSeleccionada;
    }

    public void setReservaSeleccionada(Reserva reservaSeleccionada) {
        this.reservaSeleccionada = reservaSeleccionada;
    }
}