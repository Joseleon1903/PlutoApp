package com.pluto.aplication.model.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.*;

@Entity
@Data
public class PlutoUser implements Serializable {

    private static final long serialVersionUID = -3571211166033652642L;

    @Id
    @SequenceGenerator(name = "id_pluto_user_seq", sequenceName = "pluto_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_pluto_user_seq")
    private long id;
    private String username;
    private String password;
    @OneToOne(cascade = {CascadeType.ALL})
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles = new HashSet<>();

    public PlutoUser(long id) {
        this.id = id;
    }

    public PlutoUser(String username) {
        this.username = username;
    }

    public PlutoUser() {}

    @Override
    public String toString() {
        return "SystemUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                ", roles=" + roles.size() +
                '}';
    }
}
