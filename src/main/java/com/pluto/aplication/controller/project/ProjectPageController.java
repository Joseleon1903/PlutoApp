package com.pluto.aplication.controller.project;

import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.mapping.ProjectMapping;
import com.pluto.aplication.model.dto.form.ProjectFormDTO;
import com.pluto.aplication.model.dto.form.SearchFormDTO;
import com.pluto.aplication.model.entity.ErrorException;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.service.interfaces.ErrorExceptionService;
import com.pluto.aplication.service.interfaces.ProjectService;
import com.pluto.aplication.util.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jose eduardo on 3/19/2020.
 */
@Controller
public class ProjectPageController {

    Logger logger = LoggerFactory.getLogger(ProjectDetailPageController.class);

    @Autowired
    private ErrorExceptionService exceptionService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectFormDTO projectFormDTO;

    @Autowired
    private ProjectFormDTO projectUpdateFormDTO;

    @Autowired
    private SearchFormDTO searchFormDTO;

    @RequestMapping("/project")
    public String projectPage(Model model, @RequestParam(name ="error", required = false) String error){
        logger.info("entry point display projectPage");

        logger.info("param error "+ error);
        model.addAttribute("projectBean", projectFormDTO);
        model.addAttribute("projectUpdate", projectUpdateFormDTO);
        model.addAttribute("searchBean", searchFormDTO);
        model.addAttribute("projectList",projectService.findAllProjects());
        ApplicationUtil.validateErrorPage(error, model, exceptionService);

        return "project/ProjectPage";
    }


    @RequestMapping(value = "/project/registration", method = RequestMethod.POST)
    public String registerProject(@ModelAttribute(value="projectData") ProjectFormDTO projectFormDTO, Model model){
        logger.info("entry point display registerProject");
        logger.info("Param: "+projectFormDTO);

        //integrity validation
        if(!ApplicationUtil.isStringNullOrEmpty(projectFormDTO.getDescription()) ||
                !ApplicationUtil.isStringNullOrEmpty(projectFormDTO.getName())){
            return "redirect:/project?error="+ConstantAplication.INVALID_INPUT_FORM;
        }

        //project name validation
        Project project = projectService.findByName(projectFormDTO.getName());
        if(project != null){
            return "redirect:/project?error="+ConstantAplication.DUPLICATE_PROJECT_NAME;
        }
        projectService.save(ProjectMapping.convertToFormDto(projectFormDTO));
        return "redirect:/project";
    }

    @RequestMapping(value = "/project/update", method = RequestMethod.POST)
    public String updateProject(@ModelAttribute(value="projectUpdateData") ProjectFormDTO projectFormDTO, Model model){
        logger.info("entry point display registerProject");
        logger.info("Param: "+projectFormDTO);

        //integrity validation
        if(!ApplicationUtil.isStringNullOrEmpty(projectFormDTO.getName()) ||
                !ApplicationUtil.isStringNullOrEmpty(projectFormDTO.getDescription())){
            return "redirect:/project?error="+ConstantAplication.INVALID_INPUT_FORM;
        }
        Project projectEntity = projectService.findByName(projectFormDTO.getName());
        projectEntity.setDescription(projectFormDTO.getDescription());
        projectEntity.setName(projectFormDTO.getName());
        projectService.save(projectEntity);
        return "redirect:/project";
    }

    @RequestMapping(value = "/project/search", method = RequestMethod.POST)
    public String searchProject(@ModelAttribute(value="searchData") SearchFormDTO searchBean, Model model){
        logger.info("entry point display searchProject");
        logger.info("Search Param : "+searchBean);

        Project project = projectService.findByName(searchBean.getContent());

        if(project == null){
            return "redirect:/project?error="+ConstantAplication.PROJECT_NOT_FOUND;
        }
        projectUpdateFormDTO = ProjectMapping.convertToFormDto(project);
        model.addAttribute("projectUpdate", projectUpdateFormDTO);
        model.addAttribute("projectBean", projectFormDTO);
        model.addAttribute("searchBean", searchFormDTO);
        model.addAttribute("projectList",projectService.findAllProjects());

        return "project/ProjectPage";
    }

}
