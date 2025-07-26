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
        products.add(new Product("Ajedrez", "ajedrez.jpeg", 80, "Disponible"));
        products.add(new Product("Gamer", "gamer.jpeg", 120, "Disponible"));
        products.add(new Product("Batman", "b2.jpeg", 200, "Disponible"));
        products.add(new Product("Acuaman", "vip4.jpeg", 150, "Ocupado"));
        products.add(new Product("volcan activo", "vip1.jpeg", 180, "Ocupado"));
        products.add(new Product("Futurista", "vip2.jpeg", 220, "Ocupado"));
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
