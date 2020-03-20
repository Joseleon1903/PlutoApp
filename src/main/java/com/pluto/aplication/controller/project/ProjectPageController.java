package com.pluto.aplication.controller.project;

import com.pluto.aplication.mapping.ProjectMapping;
import com.pluto.aplication.model.dto.form.ProjectFormDTO;
import com.pluto.aplication.model.dto.form.SearchFormDTO;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.service.interfaces.ProjectService;
import com.pluto.aplication.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jose eduardo on 3/19/2020.
 */
@Controller
public class ProjectPageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectFormDTO projectFormDTO;

    @Autowired
    private ProjectFormDTO projectUpdateFormDTO;

    @Autowired
    private SearchFormDTO searchFormDTO;

    @RequestMapping("/project")
    public String projectPage(Model model){
        System.out.println("entry point display projectPage");

        model.addAttribute("projectBean", projectFormDTO);

        model.addAttribute("projectUpdate", projectUpdateFormDTO);

        model.addAttribute("searchBean", searchFormDTO);

        model.addAttribute("projectList",projectService.findAllProjects());

        return "project/ProjectPage";
    }


    @RequestMapping(value = "/project/registration", method = RequestMethod.POST)
    public String registerProject(@ModelAttribute(value="projectData") ProjectFormDTO projectFormDTO, Model model){
        System.out.println("entry point display registerProject");
        System.out.println("Param: "+projectFormDTO);

        if(ApplicationUtil.isStringNullOrEmpty(projectFormDTO.getName()) &&
                ApplicationUtil.isStringNullOrEmpty(projectFormDTO.getDescription())){

            projectService.save(ProjectMapping.convertToFormDto(projectFormDTO));
        }
        return "redirect:/project";
    }

    @RequestMapping(value = "/project/update", method = RequestMethod.POST)
    public String updateProject(@ModelAttribute(value="projectUpdateData") ProjectFormDTO projectFormDTO, Model model){
        System.out.println("entry point display registerProject");
        System.out.println("Param: "+projectFormDTO);

        Project projectEntity = projectService.findById(projectFormDTO.getId());

        if(ApplicationUtil.isStringNullOrEmpty(projectFormDTO.getName()) &&
                ApplicationUtil.isStringNullOrEmpty(projectFormDTO.getDescription())
                && projectEntity != null){

            projectEntity.setDescription(projectFormDTO.getDescription());
            projectEntity.setName(projectFormDTO.getName());

            projectService.save(projectEntity);
        }
        return "redirect:/project";
    }

    @RequestMapping(value = "/project/search", method = RequestMethod.POST)
    public String searchProject(@ModelAttribute(value="searchData") SearchFormDTO searchBean, Model model){
        System.out.println("entry point display searchProject");
        System.out.println("Search Param : "+searchBean);

        Project project = projectService.findByName(searchBean.getContent());

        if(project != null){
            projectUpdateFormDTO = ProjectMapping.convertToFormDto(project);
        }

        model.addAttribute("projectUpdate", projectUpdateFormDTO);

        model.addAttribute("projectBean", projectFormDTO);

        model.addAttribute("searchBean", searchFormDTO);

        model.addAttribute("projectList",projectService.findAllProjects());

        return "project/ProjectPage";
    }



}
