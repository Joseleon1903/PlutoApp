package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.*;
import com.pluto.aplication.repository.*;
import com.pluto.aplication.service.interfaces.TaskService;
import com.pluto.aplication.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/23/2020.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IterationRepository iterationRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    @Override
    public Task created(long projectId, Task task) {
        Priority priority = priorityRepository.findByValue(task.getPriority().getValue().toUpperCase());
        Project projectEntity = projectRepository.findById(projectId).get();
        Iteration iterationEntity = iterationRepository.findByName(task.getIteration().getName());
        iterationEntity.setProject(projectEntity);
        task.setPriority(priority);
        task.setIteration(iterationEntity);
        long id = taskRepository.getNextSeriesId();
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findAll() {
        List<Task> list =  new ArrayList<>();
        taskRepository.findAll().forEach(item ->{
            list.add(item);
        });
        return list;
    }

    @Override
    public Page<Task> findAllPaginated(int page, int entry, String searchText, String type, String priority, Boolean done) {
        Pageable pageable= PageRequest.of(page, entry);
        if(searchText == null && !ApplicationUtil.isStringNullOrEmpty(type) && !ApplicationUtil.isStringNullOrEmpty(priority) &&
               done == null){
            return taskRepository.findAll(pageable);
        }
        if(searchText == null ){
            searchText="";
        }
        String searchVal = ApplicationUtil.containQueryValue(searchText);
        return taskRepository.findByTaskTittle(searchVal, type, priority, done, pageable);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task addAttachment(long taskId, Attachment attachment) {
        Task entity = taskRepository.findById(taskId).get();
        entity.getAttachments().add(attachment);
        return taskRepository.save(entity);
    }

    @Override
    public Task addComment(long taskId, Comment comment) {
        Task entiTask = taskRepository.findById(taskId).get();
        Comment commentEntity = commentRepository.save(comment);
        entiTask.getCommnets().add(commentEntity);
        return taskRepository.save(entiTask);
    }

    @Override
    public List<Task> findByIterationId(long iterationId) {
        return taskRepository.findByIterationId(iterationId);
    }
}
