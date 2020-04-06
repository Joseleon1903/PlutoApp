package com.pluto.aplication.controller.task;

import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.controller.project.ProjectDetailPageController;
import com.pluto.aplication.model.dto.form.TaskFilterData;
import com.pluto.aplication.model.dto.form.TaskListSearchForm;
import com.pluto.aplication.model.entity.Task;
import com.pluto.aplication.service.interfaces.TaskService;
import com.pluto.aplication.util.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by jose eduardo on 3/22/2020.
 */
@Controller
public class TaskListPageController {

    Logger logger = LoggerFactory.getLogger(ProjectDetailPageController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskListSearchForm taskListSearchForm;

    @Autowired
    private TaskFilterData taskFilterData;

    @RequestMapping("/task/list")
    public String taskPageList(Model model,@RequestParam(name ="showEntry", required = false) Integer showEntry,
                           @RequestParam(name ="showPageindex", required = false) Integer showPageindex,
                           @RequestParam(name ="searchText", required = false) String searchText,
                           @RequestParam(name ="type", required = false) String type,
                           @RequestParam(name ="priority", required = false) String priority,
                           @RequestParam(name ="done", required = false) String done){

        logger.info("entry point display taskPageList");
        logger.info("param: "+ searchText);
        logger.info("param type: "+ type);
        logger.info("param priority: "+ priority);
        logger.info("param done: "+ done);

        logger.info("validation showEntry");
        if(showEntry == null){
            showEntry = ConstantAplication.DEFAULT_PAGINATION_ENTRY;
        }

        logger.info("validation en showPageIndex");
        if(showPageindex == null){
            showPageindex = ConstantAplication.DEFAULT_PAGINATION_INDEX;
        }
        Boolean isDone =ApplicationUtil.IsDoneConvert(done);
        Page<Task> entityList= taskService.findAllPaginated(showPageindex, showEntry, searchText, type, priority, isDone);
        int total = Integer.parseInt( entityList.getTotalElements()+"");
        model.addAttribute("taskList", entityList);
        model.addAttribute("pageableBean", ApplicationUtil.getShowDataTable(showEntry,total));
        model.addAttribute("searchBean", taskListSearchForm);
        model.addAttribute("taskFilterBean", taskFilterData);

        return "task/TaskListPage";
    }

    @RequestMapping(value = "/task/list", method = RequestMethod.POST)
    public String searchTask(@ModelAttribute(value="searchtext") TaskListSearchForm taskListSearchForm){
        logger.info("entering in method searchTask");
        logger.info("Param: "+ taskListSearchForm);
        UriComponentsBuilder uriComponents = UriComponentsBuilder.newInstance();
        uriComponents.path("redirect:/task/list");

        if(ApplicationUtil.isStringNullOrEmpty(taskListSearchForm.getDone())){
            uriComponents.queryParam("done",taskListSearchForm.getDone() );
        }
        if(ApplicationUtil.isStringNullOrEmpty(taskListSearchForm.getType())){
            uriComponents.queryParam("type",taskListSearchForm.getType() );
        }
        if(ApplicationUtil.isStringNullOrEmpty(taskListSearchForm.getPriority())){
            uriComponents.queryParam("priority",taskListSearchForm.getPriority() );
        }
        if(taskListSearchForm != null && ApplicationUtil.isStringNullOrEmpty(taskListSearchForm.getContent())){
            uriComponents.queryParam("searchText",taskListSearchForm.getContent() );
        }

        uriComponents.queryParam("showEntry", taskListSearchForm.getShowEntry());
        return uriComponents.toUriString();
    }

}
