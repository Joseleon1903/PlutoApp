package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.PlutoUser;

public interface UserInterfaces {

    Iterable<PlutoUser> findAllUsers();

    PlutoUser findById(Long id);

    PlutoUser createUser(PlutoUser user);

    PlutoUser updateUser(PlutoUser user);

    PlutoUser findByUsername(String username);

    PlutoUser saveOnSystem(PlutoUser user);

}
