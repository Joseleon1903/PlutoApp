package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jleon on 6/11/2018.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

}
