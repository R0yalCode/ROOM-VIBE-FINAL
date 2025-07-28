package edu.unl.cc.roomvibe.controllers.security;

import edu.unl.cc.roomvibe.bussiness.SecurityFacade;
import edu.unl.cc.roomvibe.bussiness.services.RoleRepository;
import edu.unl.cc.roomvibe.domain.security.Role;
import edu.unl.cc.roomvibe.domain.security.User;
import edu.unl.cc.roomvibe.exception.EntityNotFoundException;
import edu.unl.cc.roomvibe.faces.FacesUtil;
import edu.unl.cc.roomvibe.util.EncryptorManager;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serial;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

@Named
@ViewScoped
public class UserHome implements java.io.Serializable{

    private static Logger logger = Logger.getLogger(UserHome.class.getName());

    @Serial
    private static final long serialVersionUID = 1L;

    private Long selectedUserId;

    private User user;

    private String rolSeleccionado;

    private List<Role> rolesDisponibles;

    @Inject
    private RoleRepository roleRepository;

    @Inject
    SecurityFacade securityFacade;


    public UserHome() {
    }

    @PostConstruct
    public void init() {
        rolesDisponibles = new ArrayList<>(roleRepository.findAllWithPermissions());
    }

    public void loadUser() {
        logger.info("Loading user with id: " + selectedUserId);
        if (selectedUserId != null) {
            try {
                user = securityFacade.find(selectedUserId);
                if (user.getPerson() == null) {
                    user.setPerson(new edu.unl.cc.roomvibe.domain.common.Person());
                }
            } catch (EntityNotFoundException e) {
                FacesUtil.addErrorMessage("No se pudo encontrar el usuario con id: " + selectedUserId);
            }
        } else {
            user = new User();
        }
        decryptPassword(user);
    }

    private void decryptPassword(User user){
        String pwdDecrypted = null;
        try {
            if (user.getPassword() != null && !user.getPassword().isEmpty()){
                logger.info("Password no nulo y no vacio: " + user.getPassword());
                pwdDecrypted = EncryptorManager.decrypt(user.getPassword());
                user.setPassword(pwdDecrypted);
            }

        } catch (Exception e) {
            e.printStackTrace();
            FacesUtil.addErrorMessage(e.getMessage(), "Invconveniente al decifrar la clave: " + e.getMessage());
        }

    }

    public String create() {
        try {
            if (user.getRoles() == null) {
                user.setRoles(new HashSet<>());
            }
            Role rol = roleRepository.find(rolSeleccionado);
            user.getRoles().add(rol);

            user = securityFacade.create(user);
            //decryptPassword(user);
            FacesUtil.addSuccessMessageAndKeep("Usuario creado correctamente");
            return "userList?faces-redirect=true";
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Inconveniente al crear usuario: " + e.getMessage());
            return null;
        }
    }

    public String update() {
        try {
            securityFacade.update(user);
            //decryptPassword(user);
            FacesUtil.addSuccessMessageAndKeep("Usuario actualizado correctamente");
            return "userList?faces-redirect=true";
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Inconveniente al actualizar usuario: " + e.getMessage());
            return null;
        }
    }

    public boolean hasRole(String roleName) {
        return user != null && user.getRoles().stream()
                .anyMatch(r -> r.getName().equalsIgnoreCase(roleName));
    }

    public boolean isManaged(){
        return this.user.getId() != null;
    }

    public Long getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(Long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        UserHome.logger = logger;
    }

    public String getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(String rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public List<Role> getRolesDisponibles() {
        return rolesDisponibles;
    }

    public void setRolesDisponibles(List<Role> rolesDisponibles) {
        this.rolesDisponibles = rolesDisponibles;
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public SecurityFacade getSecurityFacade() {
        return securityFacade;
    }

    public void setSecurityFacade(SecurityFacade securityFacade) {
        this.securityFacade = securityFacade;
    }
}
