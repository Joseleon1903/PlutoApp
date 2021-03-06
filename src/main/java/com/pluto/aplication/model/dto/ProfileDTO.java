package com.pluto.aplication.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class ProfileDTO implements Serializable {

    private static final long serialVersionUID = -6459950174350417512L;
    
	public String firstName;
    public String lastName;
    public String email;
    public String mobilePhone;

    public ProfileDTO(){}


}
