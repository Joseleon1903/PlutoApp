package com.pluto.aplication.model.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
public class SystemUser implements Serializable {

    private static final long serialVersionUID = -3571211166033652642L;

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "system_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
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

    public SystemUser(long id) {
        this.id = id;
    }

    public SystemUser(String username) {
        this.username = username;
    }

    public SystemUser() {}

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
