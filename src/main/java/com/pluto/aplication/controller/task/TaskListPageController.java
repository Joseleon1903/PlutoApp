package com.pluto.aplication.controller.task;

import com.pluto.aplication.service.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jose eduardo on 3/22/2020.
 */
@Controller
public class TaskListPageController {


    @Autowired
    private TaskService taskService;

    @RequestMapping("/task/list")
    public String taskPage(Model model){
        System.out.println("entry point display home");

        model.addAttribute("taskList",taskService.findAll());

        return "task/TaskListPage";
    }

}
