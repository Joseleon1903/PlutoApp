package com.pluto.aplication.model.dto.form;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ProviderFormData {

    private long id;
    private String name;
    private String address;
    private String phone;
    private String email;

    public ProviderFormData() {
    }

}