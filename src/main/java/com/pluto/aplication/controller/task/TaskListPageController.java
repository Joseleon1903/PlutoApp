package com.pluto.aplication.controller.task;

import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.constant.UtilityAplication;
import com.pluto.aplication.controller.project.ProjectDetailPageController;
import com.pluto.aplication.model.dto.ShowTableData;
import com.pluto.aplication.model.dto.form.CommentFormData;
import com.pluto.aplication.model.dto.form.SearchFormDTO;
import com.pluto.aplication.model.dto.form.TaskFormData;
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

import java.security.Principal;
import java.util.List;

/**
 * Created by jose eduardo on 3/22/2020.
 */
@Controller
public class TaskListPageController {

    Logger logger = LoggerFactory.getLogger(ProjectDetailPageController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private SearchFormDTO searchFormDTO;

    @RequestMapping("/task/list")
    public String taskPageList(Model model,@RequestParam(name ="showEntry", required = false) Integer showEntry,
                           @RequestParam(name ="showPageindex", required = false) Integer showPageindex,
                           @RequestParam(name ="searchText", required = false) String searchText){
        logger.info("entry point display taskPageList");
        logger.info("param "+ searchText);

        logger.info("validation showEntry");
        if(showEntry == null){
            showEntry = ConstantAplication.DEFAULT_PAGINATION_ENTRY;
        }

        logger.info("validation en showPageIndex");
        if(showPageindex == null){
            showPageindex = ConstantAplication.DEFAULT_PAGINATION_INDEX;
        }

        Page<Task> entityList= taskService.findAllPaginated(showPageindex, showEntry, searchText);
        int total = Integer.parseInt( entityList.getTotalElements()+"");
        model.addAttribute("taskList", entityList);
        model.addAttribute("pageableBean", ApplicationUtil.getShowDataTable(showEntry,total));
        model.addAttribute("searchBean", searchFormDTO);

        return "task/TaskListPage";
    }

    @RequestMapping(value = "/task/list", method = RequestMethod.POST)
    public String searchTask(@ModelAttribute(value="searchtext") SearchFormDTO searchFormDTO){
        logger.info("entering in method searchTask");
        logger.info("Param: "+ searchFormDTO);

        if(searchFormDTO != null && ApplicationUtil.isStringNullOrEmpty(searchFormDTO.getContent())){
            return "redirect:/task/list?searchText="+ searchFormDTO.getContent()+"&showEntry="+searchFormDTO.getShowEntry();
        }
        String entry[] = searchFormDTO.getShowEntry().split(",");
        return "redirect:/task/list?showEntry="+entry[1];
    }

}
