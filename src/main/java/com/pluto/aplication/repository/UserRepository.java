package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User, Long> {

   @Query("select u from User u where u.username like ?1")
   User findByUsername(String username);

}
