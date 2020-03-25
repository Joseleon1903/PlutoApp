package com.pluto.aplication.controller.task;

import com.pluto.aplication.mapping.ProjectMapping;
import com.pluto.aplication.mapping.TaskMapping;
import com.pluto.aplication.model.dto.form.TaskFormData;
import com.pluto.aplication.model.dto.form.TaskViewFormData;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.model.entity.Task;
import com.pluto.aplication.service.interfaces.StatementService;
import com.pluto.aplication.service.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Controller
public class TaskDetailController {


    @Autowired
    private TaskService taskService;

    @Autowired
    private StatementService statementService;

    @Autowired
    private TaskViewFormData taskViewFormData;

    @RequestMapping("/task/{taskId}/detail")
    public String taskPage(Model model , @PathVariable("taskId") Long taskId){
        System.out.println("entry point display taskPageDetail");
        System.out.println("Param : "+taskId);

        Task entity = taskService.findById(taskId);

        taskViewFormData = TaskMapping.convertEntityToDto(entity);
        model.addAttribute("taskViewFormBean",taskViewFormData );
        return "task/TaskDetailPage";
    }

    @RequestMapping(value = "/task/update", method = RequestMethod.POST)
    public String updateTask(@ModelAttribute(value="taskData") TaskViewFormData taskViewFormData, Model model){
        System.out.println("entry point display taskPageDetail updateTask");
        System.out.println("param : "+taskViewFormData);

        Task entity = taskService.findById(taskViewFormData.getId());

        entity.setType(taskViewFormData.getType());
        entity.setStatus(taskViewFormData.getStatus());
        entity.setStatement(statementService.findByName(taskViewFormData.getStatement()));
        entity.setStartDate(taskViewFormData.getStartDate());
        entity.setEndDate(taskViewFormData.getEndDate());
        taskService.update(entity);

        return "redirect:/task/"+taskViewFormData.getId()+"/detail";
    }



}
