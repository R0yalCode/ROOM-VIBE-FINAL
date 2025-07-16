package edu.unl.cc.jbrew.faces;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("ValidatorBean")
public class ValidatorBean implements Validator<Object> {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String clientId = component.getClientId(context);

        if (clientId.contains("nombre")) {
            validarNombre(value);
        } else if (clientId.contains("email")) {
            validarCorreo(value);
        }
    }

    private void validarNombre(Object value) {
        String nombre = (value != null) ? value.toString().trim() : "";
        if (nombre.isEmpty()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campo obligatorio", "El nombre no puede estar vacío."));
        }

        if (!nombre.matches("[A-Za-zÀ-ÿ\\s]+")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Nombre inválido", "Solo se permiten letras y espacios."));
        }
    }

    private void validarCorreo(Object value) {
        String correo = (value != null) ? value.toString().trim() : "";
        if (correo.isEmpty()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campo obligatorio", "El correo electrónico no puede estar vacío."));
        }

        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (!correo.matches(regex)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Correo inválido", "Formato de correo no válido."));
        }
    }


}
