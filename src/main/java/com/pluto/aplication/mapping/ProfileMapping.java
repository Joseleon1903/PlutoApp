package com.pluto.aplication.mapping;

import com.pluto.aplication.model.dto.form.ProfileFormData;
import com.pluto.aplication.model.entity.SystemUser;

public class ProfileMapping{

    private ProfileMapping(){}

    public static ProfileFormData convertFromEntity(SystemUser user){
        ProfileFormData entityout = new ProfileFormData();
        entityout.setUsername(user.getUsername());
        entityout.setFirstName(user.getProfile().getFirstName());
        entityout.setLastName(user.getProfile().getLastName());
        entityout.setMobilePhone(user.getProfile().getMobilePhone());
        if(user.getProfile().getImage() != null){
            entityout.setProfileImageUrl(user.getProfile().getImage().getFileViewUri());
        }
        entityout.setEmail(user.getProfile().getEmail());
        return entityout;
    }

}