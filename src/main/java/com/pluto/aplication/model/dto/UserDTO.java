package com.pluto.aplication.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 6972588677114510106L;
    
	private long id;
    private String username;
    private String password;

    public UserDTO() {

    }

    public UserDTO(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


}
