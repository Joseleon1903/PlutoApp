package com.pluto.aplication.controller.task;

import com.pluto.aplication.mapping.ProjectMapping;
import com.pluto.aplication.mapping.TaskMapping;
import com.pluto.aplication.model.dto.form.ProjectFormDTO;
import com.pluto.aplication.model.dto.form.SearchFormDTO;
import com.pluto.aplication.model.dto.form.TaskFormData;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.service.interfaces.IterationService;
import com.pluto.aplication.service.interfaces.ProjectService;
import com.pluto.aplication.service.interfaces.TaskService;
import com.pluto.aplication.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by jose eduardo on 3/22/2020.
 */
@Controller
public class TaskPageController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskFormData taskFormData;

    @Autowired
    private IterationService iterationService;

    @Autowired
    private SearchFormDTO searchFormDTO;

    @Autowired
    private ProjectFormDTO projectFormDTO;

    @RequestMapping("/task/create")
    public String taskPage(Model model , @RequestParam(name ="projectId", required = false) Long projectId ){
        System.out.println("entry point display home");

        System.out.println("param : "+projectId);

        model.addAttribute("searchBean", searchFormDTO);

        model.addAttribute("iterationList", new ArrayList<>());

        if(projectId != null){

            Project project = projectService.findById(projectId);

            projectFormDTO = ProjectMapping.convertToFormDto(project);

            model.addAttribute("iterationList", iterationService.findByProjectId(projectFormDTO.getId()));

        }

        model.addAttribute("projectBean", projectFormDTO);


        model.addAttribute("taskFormBean", taskFormData);

        return "task/TaskPage";
    }

    @RequestMapping(value = "task/Add", method = RequestMethod.POST)
    public String registerTaskProject(@ModelAttribute(value="taskData") TaskFormData taskFormData){
        System.out.println("entry point display registerProject");
        System.out.println("Param: "+taskFormData);

        long projectId = taskFormData.getProjectId();

        long iterationId = iterationService.findByName(taskFormData.getIterationName()).getId();

        if(ApplicationUtil.isStringNullOrEmpty(taskFormData.getTittle()) &&
                ApplicationUtil.isStringNullOrEmpty(taskFormData.getTaskDetail()) &&
                ApplicationUtil.isStringNullOrEmpty(taskFormData.getPriority()) &&
                ApplicationUtil.isStringNullOrEmpty(taskFormData.getType())){

            taskService.created(projectId, iterationId, TaskMapping.convertToFormDto(taskFormData));
        }
        return "redirect:/task/create";
    }



    @RequestMapping(value = "/task/search", method = RequestMethod.POST)
    public String searchProject(@ModelAttribute(value="searchData") SearchFormDTO searchBean, Model model){
        System.out.println("entry point display searchProject");
        System.out.println("Search Param : "+searchBean);

        model.addAttribute("searchBean", searchFormDTO);

        Project project = projectService.findByName(searchBean.getContent());

        if(project != null){
            projectFormDTO = ProjectMapping.convertToFormDto(project);
        }
        return "redirect:/task/create?projectId="+project.getId();
    }


}
