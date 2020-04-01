package com.pluto.aplication.model.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
public class SystemUser implements Serializable {

    private static final long serialVersionUID = -3571211166033652642L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @OneToOne(cascade = {CascadeType.ALL})
    private Profile profile;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();


    public SystemUser(long id) {
        this.id = id;
    }

    public SystemUser(String username) {
        this.username = username;
    }

    public SystemUser() {}
    

}
