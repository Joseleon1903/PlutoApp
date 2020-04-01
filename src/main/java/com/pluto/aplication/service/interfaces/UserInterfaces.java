package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.SystemUser;

public interface UserInterfaces {

    Iterable<SystemUser> findAllUsers();

    SystemUser findById(Long id);

    SystemUser createUser(SystemUser user);

    SystemUser updateUser(SystemUser user);

    SystemUser findByUsername(String username);

    SystemUser saveOnSystem(SystemUser user);

}
