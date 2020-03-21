package com.pluto.aplication.controller.project;

import com.pluto.aplication.mapping.IterationMapping;
import com.pluto.aplication.model.dto.form.IterationFormData;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.service.interfaces.IterationService;
import com.pluto.aplication.service.interfaces.ProjectService;
import com.pluto.aplication.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jose eduardo on 3/21/2020.
 */
@Controller
public class ProjectDetailPageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IterationService iterationService;

    @Autowired
    private IterationFormData iterationFormData;


    @RequestMapping("/project/detail")
    public String projectDetailPage(Model model,@RequestParam("projectId") Long projectId ){
        System.out.println("entry point display projectPage");

        Project project = projectService.findById(projectId);
        model.addAttribute("projectBean", project);
        model.addAttribute("iterationBeanForm", iterationFormData);
        model.addAttribute("iterationList", iterationService.findByProjectId(projectId));

        return "project/ProjectDetailPage";
    }

    @RequestMapping(value = "/project/iteration/create", method = RequestMethod.POST)
    public String registerIterationProject(@ModelAttribute(value="iterationData") IterationFormData iterationFormData, Model model){
        System.out.println("entry point display registerIterationProject");
        System.out.println("param: "+ iterationFormData);
        System.out.println("projectId: "+ iterationFormData.getProjectId());

        if((ApplicationUtil.isNullOrEmpty(iterationFormData.getProjectId()) &&
                ApplicationUtil.isStringNullOrEmpty(iterationFormData.getName()) &&
                ApplicationUtil.isStringNullOrEmpty(iterationFormData.getDescription()) &&
                ApplicationUtil.isNullOrEmpty(iterationFormData.getInitDate()) &&
                ApplicationUtil.isNullOrEmpty(iterationFormData.getEndDate()))){

            System.out.println("Validation input success");

            iterationService.save(iterationFormData.getProjectId(), IterationMapping.convertToFormDto(iterationFormData));

        }

        return "redirect:/project/detail?projectId="+iterationFormData.getProjectId();
    }





}
