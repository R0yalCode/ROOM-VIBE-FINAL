package edu.unl.cc.roomvibe.domain.security;

import edu.unl.cc.roomvibe.domain.common.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findLikeName", query = "SELECT o FROM User o WHERE o.name LIKE :name"),
        @NamedQuery(name = "User.findById", query = "SELECT o FROM User o WHERE o.id = :id")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    private Person person;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;

    public User() {
        this.roles = new HashSet<>();
        this.person = new Person(); // Garantiza que no sea null
    }

    public User(Long id, String name, String password) {
        this();
        this.id = id;
        this.name = sanitizeAndValidateName(name);
        this.password = password;
    }

    public User(Long id, String name, String password, Person person) {
        this(id, name, password);
        this.person = person;
    }

    private String sanitizeAndValidateName(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio.");
        }
        String cleaned = text.trim();
        if (cleaned.length() < 5) {
            throw new IllegalArgumentException("El nombre de usuario debe tener al menos 5 caracteres.");
        }
        return cleaned.toLowerCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = sanitizeAndValidateName(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name=" + name + ", person=" + person + "}";
    }
}