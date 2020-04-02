package com.pluto.aplication.repository;

import com.pluto.aplication.model.entity.Attachment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose eduardo on 3/26/2020.
 */
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {

    @Query(value = "SELECT nextval('attachment_seq')", nativeQuery = true)
    Long getNextSeriesId();
    
}
