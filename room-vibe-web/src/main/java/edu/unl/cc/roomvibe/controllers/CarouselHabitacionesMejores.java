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
public class CarouselHabitacionesMejores implements Serializable {

    private List<Habitacion> habitaciones;
    private List<ResponsiveOption> responsiveOptions;

    @PostConstruct
    public void init() {
        habitaciones = List.of(
                new Habitacion("Habitación Sencilla", "images/habitaciones/sencilla.jpg", "Ideal para viajeros solos."),
                new Habitacion("Ejecutiva", "images/habitaciones/suite.jpg", "Espacio moderno..."),
                new Habitacion("Habitación Económica", "images/habitaciones/economica.jpg", "Espacio funcional y cómodo."),
                new Habitacion("Triple Familiar", "images/habitaciones/habitacionLujo.jpg", "Ideal para familias..."),
                new Habitacion("Royal Suite", "images/habitaciones/suiteVip.jpeg", "Elegancia total..."),
                new Habitacion("VIP Total", "images/habitaciones/topSuite.jpg", "Lujo sin igual...")
        );

        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<ResponsiveOption> getResponsiveOptions() {
        return responsiveOptions;
    }

    public static class Habitacion {
        private String nombre;
        private String imagen;
        private String descripcion;

        public Habitacion(String nombre, String imagen, String descripcion) {
            this.nombre = nombre;
            this.imagen = imagen;
            this.descripcion = descripcion;
        }

        public String getNombre() {
            return nombre;
        }

        public String getImagen() {
            return imagen;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }
}