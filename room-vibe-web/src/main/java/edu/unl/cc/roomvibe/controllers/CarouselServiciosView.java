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
public class CarouselServiciosView implements Serializable {

    private List<Servicio> servicios;
    private List<ResponsiveOption> responsiveOptions;

    @PostConstruct
    public void init() {
        servicios = List.of(
                new Servicio("Spa", "images/servicios/spa.jpg", "$30", "Relájate en nuestro spa con masajes y tratamientos."),
                new Servicio("Desayuno Buffet", "images/servicios/desayuno.jpg", "$15", "Desayuno variado y saludable cada mañana."),
                new Servicio("Gimnasio", "images/servicios/gimnasio.jpg", "Incluido", "Acceso libre a nuestro gimnasio 24/7."),
                new Servicio("Piscina", "images/servicios/piscina.jpg", "Incluido", "Piscina climatizada para todos los huéspedes."),
                new Servicio("WiFi", "images/servicios/wifi.jpg", "Incluido", "Internet de alta velocidad en todo el hotel."),
                new Servicio("Estacionamiento", "images/servicios/estacionamiento.jpg", "$10", "Estacionamiento privado y seguro."),
                new Servicio("Seguridad 24h", "images/servicios/seguridad.jpg", "Incluido", "Vigilancia y seguridad las 24 horas."),
                new Servicio("Sala de reuniones", "images/servicios/sala.jpg", "$50/hora", "Espacios equipados para tus eventos.")
        );

        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public List<ResponsiveOption> getResponsiveOptions() {
        return responsiveOptions;
    }

    public static class Servicio {
        private String nombre;
        private String imagen;
        private String precio;
        private String descripcion;

        public Servicio(String nombre, String imagen, String precio, String descripcion) {
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
