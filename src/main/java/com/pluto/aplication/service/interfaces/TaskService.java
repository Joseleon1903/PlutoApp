package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.Attachment;
import com.pluto.aplication.model.entity.Comment;
import com.pluto.aplication.model.entity.Task;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by jose eduardo on 3/23/2020.
 */
public interface TaskService {

    Task created(long projectId, Task task);

    Task findById(Long id);

    List<Task> findAll();

    Page<Task> findAllPaginated(int page, int entry, String searchText,String type, String priority, Boolean done);

    Task update(Task task);

    Task addAttachment(long taskId, Attachment attachment);

    Task addComment(long taskId, Comment comment);

    List<Task> findByIterationId(long iterationId);

}
