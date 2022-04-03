package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.PlutoUser;
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

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProfileRepository profileRepository;


    @Override
    public Iterable<PlutoUser> findAllUsers() {
        return  userRepository.findAll();
    }

    @Override
    public PlutoUser findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public PlutoUser createUser(PlutoUser user) {

        long profileId = profileRepository.getNextSeriesId();
        long userId = userRepository.getNextSeriesId();
        user.setId(userId);
        user.getProfile().setId(profileId);
        user.getRoles().add(roleRepository.findById(1L).get());
        return saveOnSystem(user);
    }

    @Override
    public PlutoUser updateUser(PlutoUser user) {
       if (userRepository.existsById(user.getId())){
          return userRepository.save(user);
       }
       return null;
    }

    @Override
    public PlutoUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public PlutoUser saveOnSystem(PlutoUser user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
