package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.SystemUser;
import com.pluto.aplication.repository.ProfileRepository;
import com.pluto.aplication.repository.RoleRepository;
import com.pluto.aplication.repository.UserRepository;
import com.pluto.aplication.service.interfaces.UserInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserInterfaces {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProfileRepository profileRepository;


    @Override
    public Iterable<SystemUser> findAllUsers() {
        return  userRepository.findAll();
    }

    @Override
    public SystemUser findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public SystemUser createUser(SystemUser user) {

        long profileId = profileRepository.getNextSeriesId();
        long userId = userRepository.getNextSeriesId();
        user.setId(userId);
        user.getProfile().setId(profileId);
        user.getRoles().add(roleRepository.findById(1L).get());
        return saveOnSystem(user);
    }

    @Override
    public SystemUser updateUser(SystemUser user) {
       if (userRepository.existsById(user.getId())){
          return userRepository.save(user);
       }
       return null;
    }

    @Override
    public SystemUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public SystemUser saveOnSystem(SystemUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
