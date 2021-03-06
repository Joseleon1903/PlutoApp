package com.pluto.aplication.service.controller;

import com.pluto.aplication.model.dto.UserDTO;
import com.pluto.aplication.model.entity.SystemUser;
import com.pluto.aplication.service.interfaces.UserInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    UserInterfaces userService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id){
        SystemUser userEnty = userService.findById(id);
        UserDTO user = new UserDTO(userEnty.getId(),userEnty.getUsername(), userEnty.getPassword());
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> findById(@RequestBody SystemUser user){
        SystemUser userEnty = userService.createUser(user);
        UserDTO userDto = new UserDTO(userEnty.getId(),userEnty.getUsername(), userEnty.getPassword());
        return new ResponseEntity<UserDTO>(userDto, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> updateUser(@RequestBody SystemUser user){
        SystemUser userEnty = userService.updateUser(user);
        UserDTO userDto = new UserDTO(userEnty.getId(),userEnty.getUsername(), userEnty.getPassword());
        return new ResponseEntity<UserDTO>(userDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/findByUsername/{username}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<SystemUser> findByUsername(@PathVariable("username") String username){
        SystemUser userEnty = userService.findByUsername(username);
        return new ResponseEntity<SystemUser>(userEnty, HttpStatus.ACCEPTED);
    }

}
