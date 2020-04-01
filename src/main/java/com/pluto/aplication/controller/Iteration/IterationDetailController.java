package com.pluto.aplication.controller.Iteration;

import com.pluto.aplication.mapping.IterationMapping;
import com.pluto.aplication.model.dto.IterationData;
import com.pluto.aplication.model.entity.Iteration;
import com.pluto.aplication.model.entity.Task;
import com.pluto.aplication.service.interfaces.IterationService;
import com.pluto.aplication.service.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jose eduardo on 3/26/2020.
 */
@Controller
public class IterationDetailController {

    @Autowired
    private IterationData iterationData;

    @Autowired
    private IterationService iterationService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/iteration/{iterationId}/detail", method = RequestMethod.GET)
    public String displayIterationDetail(@PathVariable("iterationId") Long iterationId , Model model){

        System.out.println("Entering in displayIterationDetail");
        System.out.println("Param: "+iterationId);

        Iteration iterationEntity = iterationService.findById(iterationId);

        List<Task> taskList = taskService.findByIterationId(iterationId);

        iterationData = IterationMapping.convertToFormDto(iterationEntity, taskList);
        model.addAttribute("iterationBean", iterationData);

        return "/iteration/IterationDetailPage";
    }


}
