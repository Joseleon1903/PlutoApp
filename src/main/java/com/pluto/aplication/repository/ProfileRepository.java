package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 4/1/2020.
 */
public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @Query(value = "SELECT nextval('profile_id_seq')", nativeQuery =
            true)
    Long getNextSeriesId();

}
