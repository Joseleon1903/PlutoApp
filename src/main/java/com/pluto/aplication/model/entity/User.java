package com.pluto.aplication.model.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -3571211166033652642L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @OneToOne(cascade = {CascadeType.ALL})
    private Profile profile;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User(long id) {
        this.id = id;
    }

    public User(String username) {
        this.username = username;
    }

    public User() {}
    

}
