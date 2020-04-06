package com.pluto.aplication.controller.project;

import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.controller.profile.RegistrationController;
import com.pluto.aplication.mapping.IterationMapping;
import com.pluto.aplication.model.dto.form.IterationFormData;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.service.interfaces.ErrorExceptionService;
import com.pluto.aplication.service.interfaces.IterationService;
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
 * Created by jose eduardo on 3/21/2020.
 */
@Controller
public class ProjectDetailPageController {

    Logger logger = LoggerFactory.getLogger(ProjectDetailPageController.class);

    @Autowired
    private ErrorExceptionService exceptionService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IterationService iterationService;

    @Autowired
    private IterationFormData iterationFormData;


    @RequestMapping("/project/detail")
    public String projectDetailPage(Model model,@RequestParam(name ="error", required = false) String error,
                                    @RequestParam("projectId") Long projectId){
        logger.info("entry point display projectPage");

        Project project = projectService.findById(projectId);
        model.addAttribute("projectBean", project);
        model.addAttribute("iterationBeanForm", iterationFormData);
        model.addAttribute("iterationList", iterationService.findByProjectId(projectId));

        ApplicationUtil.validateErrorPage(error, model, exceptionService);
        return "project/ProjectDetailPage";
    }

    @RequestMapping(value = "/project/iteration/create", method = RequestMethod.POST)
    public String registerIterationProject(@ModelAttribute(value="iterationData") IterationFormData iterationFormData, Model model){
        logger.info("entry point display registerIterationProject");
        logger.info("param: "+ iterationFormData);
        logger.info("projectId: "+ iterationFormData.getProjectId());

        if((!ApplicationUtil.isNullOrEmpty(iterationFormData.getProjectId()) ||
                !ApplicationUtil.isStringNullOrEmpty(iterationFormData.getName()) ||
                !ApplicationUtil.isStringNullOrEmpty(iterationFormData.getDescription()) ||
                !ApplicationUtil.isNullOrEmpty(iterationFormData.getInitDate()) ||
                !ApplicationUtil.isNullOrEmpty(iterationFormData.getEndDate()))){

            logger.info("Validation input fail");
            return "redirect:/project/detail?projectId="+iterationFormData.getProjectId()+
                    "&error="+ConstantAplication.INVALID_INPUT_FORM;
        }
        logger.info("Validation input success");
        iterationService.save(iterationFormData.getProjectId(), IterationMapping.convertToFormDto(iterationFormData));
        return "redirect:/project/detail?projectId="+iterationFormData.getProjectId();
    }





}
