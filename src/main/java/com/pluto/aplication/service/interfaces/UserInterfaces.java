package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.User;

public interface UserInterfaces {

    Iterable<User> findAllUsers();

    User findById(Long id);

    User createUser(User user);

    User updateUser(User user);

    User findByUsername(String username);

    User saveOnSystem(User user);

}
