package edu.unl.cc.roomvibe.domain.common;

import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Steeven Pardo, Juan Calopino, Royel Jima, Daniel Savedra
 * @version 1.0
 */

@Entity
@Table(name = "reservas")
@NamedQuery(
        name = "Reserva.buscarPorCriterio",
        query = "SELECT r FROM Reserva r WHERE LOWER(r.nombre) LIKE :criterio OR LOWER(r.email) LIKE :criterio"
)
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotNull @NotEmpty @Email
    @Column(nullable = false, length = 150)
    private String email;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEntrada;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaSalida;

    @NotNull @NotEmpty
    @Column(nullable = false, length = 50)
    private String tipoHabitacion;

    @NotNull
    @Column(nullable = false)
    private Integer personas;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    private Person person;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = new Date();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Date getFechaEntrada() { return fechaEntrada;
    }
    public void setFechaEntrada(Date fechaEntrada) { this.fechaEntrada = fechaEntrada; }

    public Date getFechaSalida() { return fechaSalida; }

    public void setFechaSalida(Date fechaSalida) { this.fechaSalida = fechaSalida; }

    public String getTipoHabitacion() { return tipoHabitacion; }

    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }

    public Integer getPersonas() { return personas; }

    public void setPersonas(Integer personas) { this.personas = personas; }

    public Date getFechaCreacion() { return fechaCreacion; }

    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
                ", personas=" + personas +
                ", fechaCreacion=" + fechaCreacion +
                ", person=" + person +
                '}';
    }
}
