<<<<<<< HEAD
package edu.unl.cc.jbrew.controllers;
=======
package edu.unl.cc.roomvibe.controllers;
>>>>>>> origin/feature

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
<<<<<<< HEAD

=======
>>>>>>> origin/feature
import org.primefaces.model.ResponsiveOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
<<<<<<< HEAD
                new Habitacion("Sencilla Básica", "images/habitaciones/sencillaBasica.jpg", "$60", "Con lo esencial..."),
                new Habitacion("Ajedrez Básica", "images/habitaciones/ajedrez.jpeg", "$45", "Cómete a la reina."),
                new Habitacion("Simple", "images/habitaciones/runaway.jpeg", "$50", "Sencilla y funcional."),
                new Habitacion("Pareja", "images/habitaciones/taylor.jpeg", "$55", "Perfecta para una pareja.")
=======
                new Habitacion("Sencilla Básica", "images/habitaciones/sencillaBasica.jpg", "$60", "Con lo esencial...")
>>>>>>> origin/feature
        );

        habitacionesClaseC = List.of(
                new Habitacion("Habitación Doble", "images/habitaciones/miniSuite.png", "$75", "Para dos personas..."),
                new Habitacion("Familiar Compacta", "images/habitaciones/familiarCompacta.jpg", "$85", "Cama doble..."),
<<<<<<< HEAD
                new Habitacion("Ejecutiva", "images/habitaciones/suite.jpg", "$90", "Espacio moderno..."),
                new Habitacion("Habitación Ice Cream", "images/habitaciones/crema.jpeg", "$75", "Para dos personas..."),
                new Habitacion("Habitación Metal", "images/habitaciones/metall.jpeg", "$85", "Cama doble..."),
                new Habitacion("Habitación Gamer", "images/habitaciones/gamer.jpeg", "$90", "Espacio moderno...")

=======
                new Habitacion("Ejecutiva", "images/habitaciones/suite.jpg", "$90", "Espacio moderno...")
>>>>>>> origin/feature
        );

        habitacionesClaseB = List.of(
                new Habitacion("Deluxe Doble", "images/habitaciones/miniSuite.png", "$100", "Vista al jardín..."),
                new Habitacion("Triple Familiar", "images/habitaciones/habitacionLujo.jpg", "$110", "Ideal para familias..."),
<<<<<<< HEAD
                new Habitacion("Confort Premium", "images/habitaciones/habitacionBoutique.jpeg", "$120", "Comodidad garantizada..."),
                new Habitacion("Lobo Solitario", "images/habitaciones/b2.jpeg", "$100", "La mejor para entrar a tu mundo..."),
                new Habitacion("Habitación Tierra Pasión", "images/habitaciones/b3.jpeg", "$110", "Lo mejor para tí ..."),
                new Habitacion("Habitación del Cielo", "images/habitaciones/b1.jpeg", "$120", "Ideal para parejas...")
=======
                new Habitacion("Confort Premium", "images/habitaciones/habitacionBoutique.jpeg", "$120", "Comodidad garantizada...")
>>>>>>> origin/feature
        );

        habitacionesClaseA = List.of(
                new Habitacion("Suite Junior", "images/habitaciones/suitePremium.png", "$130", "Estilo y confort..."),
                new Habitacion("Suite Ejecutiva", "images/habitaciones/suiteEjecutiva.jpg", "$150", "Perfecta para ejecutivos..."),
<<<<<<< HEAD
                new Habitacion("Suite Panorámica", "images/habitaciones/a5.jpeg", "$200", "Vistas increíbles..."),
                new Habitacion("Suite Albañilera", "images/habitaciones/a1.jpeg", "$130", "Estilo y confort..."),
                new Habitacion("Suite Thor", "images/habitaciones/a2.jpeg", "$150", "Perfecta para amantes a los Comic..."),
                new Habitacion("Suite Lava", "images/habitaciones/a3.jpeg", "$200", "Para personas con gran imaginación...")
=======
                new Habitacion("Suite Panorámica", "images/habitaciones/matrimonial.jpeg", "$200", "Vistas increíbles...")
>>>>>>> origin/feature
        );

        habitacionesClaseVIP = List.of(
                new Habitacion("Presidencial", "images/habitaciones/suitePresidencial.png", "$250", "La más exclusiva..."),
                new Habitacion("Royal Suite", "images/habitaciones/suiteVip.jpeg", "$300", "Elegancia total..."),
<<<<<<< HEAD
                new Habitacion("VIP Total", "images/habitaciones/topSuite.jpg", "$350", "Lujo sin igual..."),
                new Habitacion("VIP Montaña", "images/habitaciones/vip1.jpeg", "500", "La más exclusiva..."),
                new Habitacion("VIP Futurista", "images/habitaciones/vip2.jpeg", "$600", "Elegancia total..."),
                new Habitacion("VIP ACUAMAN", "images/habitaciones/vip4.jpeg", "750", "Lujo sin igual...")

                );
=======
                new Habitacion("VIP Total", "images/habitaciones/topSuite.jpg", "$350", "Lujo sin igual...")
        );
>>>>>>> origin/feature

        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
<<<<<<< HEAD

=======
>>>>>>> origin/feature
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
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/feature
