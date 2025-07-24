package edu.unl.cc.roomvibe.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.ResponsiveOption;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CarouselView implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product("Habitación Estándar", "habitacion1.jpg", 80, "Disponible"));
        products.add(new Product("Habitación Doble", "habitacion2.jpg", 120, "Ocupado"));
        products.add(new Product("Suite Familiar", "habitacion3.jpg", 200, "Disponible"));
        products.add(new Product("Habitación con Vista al Mar", "habitacion4.jpg", 150, "Disponible"));
        products.add(new Product("Habitación Deluxe", "habitacion5.jpg", 180, "Ocupado"));
        products.add(new Product("Habitación Ejecutiva", "habitacion6.jpg", 220, "Disponible"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<ResponsiveOption> getResponsiveOptions() {
        List<ResponsiveOption> options = new ArrayList<>();
        options.add(new ResponsiveOption("1024px", 3, 3));
        options.add(new ResponsiveOption("768px", 2, 2));
        options.add(new ResponsiveOption("560px", 1, 1));
        return options;
    }
}
