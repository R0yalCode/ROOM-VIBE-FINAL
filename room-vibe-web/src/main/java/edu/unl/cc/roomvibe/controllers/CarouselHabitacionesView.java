package edu.unl.cc.roomvibe.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.ResponsiveOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *author:
 * Steeven Pardo
 * Juan Calopino
 * Royel Jima
 * Daniel Savedra
 */

@Named
@ViewScoped
public class CarouselHabitacionesView implements Serializable {

    private List<Habitacion> habitacionesClaseD;
    private List<Habitacion> habitacionesClaseC;
    private List<Habitacion> habitacionesClaseB;
    private List<Habitacion> habitacionesClaseA;
    private List<Habitacion> habitacionesClaseVIP;

    private List<ResponsiveOption> responsiveOptions;

    @PostConstruct
    public void init() {
        habitacionesClaseD = List.of(
                new Habitacion("Habitación Simple", "images/habitaciones/sencilla.jpg", "$50", "Ideal para viajeros..."),
                new Habitacion("Económica Individual", "images/habitaciones/economica.jpg", "$55", "Espacio funcional..."),
                new Habitacion("Sencilla Básica", "images/habitaciones/sencillaBasica.jpg", "$60", "Con lo esencial...")
        );

        habitacionesClaseC = List.of(
                new Habitacion("Habitación Doble", "images/habitaciones/miniSuite.png", "$75", "Para dos personas..."),
                new Habitacion("Familiar Compacta", "images/habitaciones/familiarCompacta.jpg", "$85", "Cama doble..."),
                new Habitacion("Ejecutiva", "images/habitaciones/suite.jpg", "$90", "Espacio moderno...")
        );

        habitacionesClaseB = List.of(
                new Habitacion("Deluxe Doble", "images/habitaciones/miniSuite.png", "$100", "Vista al jardín..."),
                new Habitacion("Triple Familiar", "images/habitaciones/habitacionLujo.jpg", "$110", "Ideal para familias..."),
                new Habitacion("Confort Premium", "images/habitaciones/habitacionBoutique.jpeg", "$120", "Comodidad garantizada...")
        );

        habitacionesClaseA = List.of(
                new Habitacion("Suite Junior", "images/habitaciones/suitePremium.png", "$130", "Estilo y confort..."),
                new Habitacion("Suite Ejecutiva", "images/habitaciones/suiteEjecutiva.jpg", "$150", "Perfecta para ejecutivos..."),
                new Habitacion("Suite Panorámica", "images/habitaciones/matrimonial.jpeg", "$200", "Vistas increíbles...")
        );

        habitacionesClaseVIP = List.of(
                new Habitacion("Presidencial", "images/habitaciones/suitePresidencial.png", "$250", "La más exclusiva..."),
                new Habitacion("Royal Suite", "images/habitaciones/suiteVip.jpeg", "$300", "Elegancia total..."),
                new Habitacion("VIP Total", "images/habitaciones/topSuite.jpg", "$350", "Lujo sin igual...")
        );

        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
    }

    // Getters
    public List<Habitacion> getHabitacionesClaseD() { return habitacionesClaseD; }
    public List<Habitacion> getHabitacionesClaseC() { return habitacionesClaseC; }
    public List<Habitacion> getHabitacionesClaseB() { return habitacionesClaseB; }
    public List<Habitacion> getHabitacionesClaseA() { return habitacionesClaseA; }
    public List<Habitacion> getHabitacionesClaseVIP() { return habitacionesClaseVIP; }
    public List<ResponsiveOption> getResponsiveOptions() { return responsiveOptions; }

    // Clase interna
    public static class Habitacion {
        private String nombre;
        private String imagen;
        private String precio;
        private String descripcion;

        public Habitacion(String nombre, String imagen, String precio, String descripcion) {
            this.nombre = nombre;
            this.imagen = imagen;
            this.precio = precio;
            this.descripcion = descripcion;
        }

        public String getNombre() { return nombre; }
        public String getImagen() { return imagen; }
        public String getPrecio() { return precio; }
        public String getDescripcion() { return descripcion; }
    }
}
