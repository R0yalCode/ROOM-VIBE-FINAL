package edu.unl.cc.roomvibe.controllers;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 * @author Steeven Pardo, Juan Calopino, Royel Jima, Daniel Savedra
 * @version 1.0
 */

@Named
@RequestScoped
public class RecuperarBean {

    private String email;

    public void enviarInstrucciones() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Correo enviado",
                        "Las instrucciones para recuperar tu contraseña han sido enviadas a tu correo. Por favor, revisa tu bandeja de entrada."));
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

