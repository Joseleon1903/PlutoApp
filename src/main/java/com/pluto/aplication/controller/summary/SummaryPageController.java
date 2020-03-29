package com.pluto.aplication.controller.summary;

import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.model.dto.SummaryData;
import com.pluto.aplication.model.dto.SummaryDetailData;
import com.pluto.aplication.model.dto.form.SummaryFormData;
import com.pluto.aplication.model.entity.Iteration;
import com.pluto.aplication.service.interfaces.ErrorExceptionService;
import com.pluto.aplication.service.interfaces.IterationService;
import com.pluto.aplication.service.interfaces.ProjectService;
import com.pluto.aplication.service.interfaces.SummaryService;
import com.pluto.aplication.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/24/2020.
 */
@Controller
public class SummaryPageController {

    @Autowired
    private ErrorExceptionService exceptionService;

    @Autowired
    private IterationService iterationService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SummaryFormData summaryFormData;

    @Autowired
    private SummaryService summaryService;

    @Autowired
    private SummaryDetailData summaryDetailData;


    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public String summayDisplayPage(Model model,
                                    @RequestParam(name ="projectName", required = false) String projectName,
                                    @RequestParam(name ="iterationName", required = false) String iterationName,
                                    @RequestParam(name ="showEntry", required = false) Integer showEntry,
                                    @RequestParam(name ="showPageindex", required = false) Integer showPageindex,
                                    @RequestParam(name ="error", required = false) String error){

        System.out.println("entering in method summayDisplayPage");

        if(!ApplicationUtil.isStringNullOrEmpty(projectName)){
            summaryFormData.setProjectName(projectName);
        }

        model.addAttribute("projectBeanList", SummaryUtil.getProjectList(projectService.findAllProjects()));
        model.addAttribute("summaryListData", new ArrayList<>());
        SummaryUtil.generateSummaryPieViewPercent(new ArrayList<>(), model);

        if(error == null && ApplicationUtil.isStringNullOrEmpty(iterationName)){
            List<SummaryData> sumaryData = summaryService.searchResumenByParam(projectName, iterationName, showPageindex, showEntry);
            model.addAttribute("summaryListData", sumaryData);
            System.out.println("Summary list count: "+ sumaryData.size());
            summaryDetailData.setSummaryCode(SummaryUtil.generateSummaryCode(projectName, iterationName));
            summaryDetailData.setSummaryPercent(SummaryUtil.generateSummaryPercent(sumaryData));
            summaryDetailData.setBuildNumber("0.0.1");
            //pie grapich attribute
            SummaryUtil.generateSummaryPieViewPercent(sumaryData, model);
            //pie grapich attribute
        }

        model.addAttribute("summaryFormBean", summaryFormData);
        model.addAttribute("summaryDetailBean", summaryDetailData);
        ApplicationUtil.validateErrorPage(error, model, exceptionService);

        return "summary/SummaryPage";
    }

    @RequestMapping(value = "/summary/search", method = RequestMethod.POST)
    public String searchProject(@ModelAttribute(value="searchData") SummaryFormData summaryFormData, Model model){
        System.out.println("entry point display searchProject");
        System.out.println("Search Param : "+summaryFormData);

        Iteration iteration = iterationService.findByName(summaryFormData.getIterationName());

        if(iteration != null && iteration.getProject().getName().equalsIgnoreCase(summaryFormData.getProjectName())){
            return "redirect:/summary?projectName="+summaryFormData.getProjectName()
                    +"&iterationName="+summaryFormData.getIterationName()
                    +"&showEntry="+25
                    +"&showPageindex="+0;
        }

        return "redirect:/summary?error="+ ConstantAplication.ITERATION_NOT_FOUND;
    }


}
