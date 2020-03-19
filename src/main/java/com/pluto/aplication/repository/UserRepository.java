package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<SystemUser, Long> {

   @Query("select u from SystemUser u where u.username like ?1")
   SystemUser findByUsername(String username);

}
