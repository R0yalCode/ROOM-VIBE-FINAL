package edu.unl.cc.roomvibe.controllers.security;

import edu.unl.cc.roomvibe.bussiness.SecurityFacade;
import edu.unl.cc.roomvibe.domain.security.User;
import edu.unl.cc.roomvibe.exception.EntityNotFoundException;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class UserList implements java.io.Serializable{

    private static Logger logger = Logger.getLogger(UserList.class.getName());

    @Serial
    private static final long serialVersionUID = 1L;

    private String criteria;
    private List<User> users;

    @Inject
    SecurityFacade securityFacade;

    public UserList() {
        users = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        logger.info("****** POST CONSTRUCTOR: " + getCriteria() + " ******");
        this.search();
    }

    public void search()  {
        try {
            logger.info("****** Ingreso a buscar con: " + getCriteriaBuffer() + " ******");
            users = securityFacade.findUsers(getCriteriaBuffer());
        } catch (EntityNotFoundException e) {
            users.clear();
        }
    }

    public String edit(User _selected){
        //FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selected", _selected);
        return "userEdit?faces-redirect=true&id=" + _selected.getId();
    }

    public void reset() {
        criteria = null;
        users.clear();
    }

    private String getCriteriaBuffer(){
        return criteria != null && !criteria.isEmpty()? criteria : "%";
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
