package com.pluto.aplication.controller.summary;

import com.pluto.aplication.model.dto.SummaryData;
import com.pluto.aplication.model.dto.form.SummaryFormData;
import com.pluto.aplication.service.interfaces.IterationService;
import com.pluto.aplication.service.interfaces.ProjectService;
import com.pluto.aplication.service.interfaces.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/24/2020.
 */
@Controller
public class SummaryPageController {

    @Autowired
    private IterationService iterationService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SummaryFormData summaryFormData;

    @Autowired
    private SummaryService summaryService;


    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public String summayDisplayPage(Model model){

        System.out.println("entering in method summayDisplayPage");

        model.addAttribute("projectBeanList", SummaryUtil.getProjectList(projectService.findAllProjects()));
        model.addAttribute("iterarionBeanList", SummaryUtil.getIterationList(iterationService.findAll()));

        model.addAttribute("summaryFormBean", summaryFormData);
        model.addAttribute("summaryListData", new ArrayList<>());

        return "summary/SummaryPage";
    }

    @RequestMapping(value = "/summary/search", method = RequestMethod.POST)
    public String searchProject(@ModelAttribute(value="searchData") SummaryFormData summaryFormData, Model model){
        System.out.println("entry point display searchProject");
        System.out.println("Search Param : "+summaryFormData);

        List<SummaryData> sumaryData = summaryService.searchResumenByParam(summaryFormData.getProjectName(), summaryFormData.getIterationName());

        System.out.println("Summary list count: "+ sumaryData.size());

        model.addAttribute("projectBeanList", SummaryUtil.getProjectList(projectService.findAllProjects()));
        model.addAttribute("iterarionBeanList", SummaryUtil.getIterationList(iterationService.findAll()));
        model.addAttribute("summaryFormBean", summaryFormData);
        model.addAttribute("summaryListData", sumaryData);

        return "summary/SummaryPage";
    }



}
