package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.PlutoUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<PlutoUser, Long> {

   @Query("select u from PlutoUser u where u.username like ?1")
   PlutoUser findByUsername(String username);

   @Query(value = "SELECT nextval('pluto_user_id_seq')", nativeQuery = true)
   Long getNextSeriesId();
}
