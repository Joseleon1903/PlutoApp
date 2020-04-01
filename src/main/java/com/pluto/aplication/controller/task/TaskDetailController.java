package com.pluto.aplication.controller.task;

import com.pluto.aplication.constant.ConstantAplication;
import com.pluto.aplication.constant.StatementType;
import com.pluto.aplication.mapping.AttachmentMapping;
import com.pluto.aplication.mapping.CommentMapping;
import com.pluto.aplication.mapping.TaskMapping;
import com.pluto.aplication.model.dto.form.CommentFormData;
import com.pluto.aplication.model.dto.form.TaskViewFormData;
import com.pluto.aplication.model.entity.Attachment;
import com.pluto.aplication.model.entity.Comment;
import com.pluto.aplication.model.entity.SystemUser;
import com.pluto.aplication.model.entity.Task;
import com.pluto.aplication.service.implementation.UserService;
import com.pluto.aplication.service.interfaces.ErrorExceptionService;
import com.pluto.aplication.service.interfaces.FileService;
import com.pluto.aplication.service.interfaces.StatementService;
import com.pluto.aplication.service.interfaces.TaskService;
import com.pluto.aplication.util.ApplicationUtil;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Controller
public class TaskDetailController {

    @Autowired
    private ErrorExceptionService exceptionService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private StatementService statementService;

    @Autowired
    private TaskViewFormData taskViewFormData;

    @Autowired
    private FileService fileService;

    @Autowired
    private CommentFormData commentFormData;

    @Autowired
    private UserService userService;

    @RequestMapping("/task/{taskId}/detail")
    public String taskPage(Model model , @PathVariable("taskId") Long taskId, @RequestParam(name ="error", required = false) String error){
        System.out.println("entry point display taskPageDetail");
        System.out.println("Param : "+taskId);

        Task entity = taskService.findById(taskId);

        taskViewFormData = TaskMapping.convertEntityToDto(entity);

        model.addAttribute("taskViewFormBean",taskViewFormData );
        model.addAttribute("attachmentBeanList", AttachmentMapping.convertToFormDtoList(entity.getAttachments()));
        model.addAttribute("commentBeanList", CommentMapping.convertToFormDtoList(entity.getCommnets()));
        model.addAttribute("commentFormBean", commentFormData);
        ApplicationUtil.validateErrorPage(error, model, exceptionService);

        return "task/TaskDetailPage";
    }

    @RequestMapping(value = "/task/update", method = RequestMethod.POST)
    public String updateTask(@ModelAttribute(value="taskData") TaskViewFormData taskViewFormData, Model model){
        System.out.println("entry point display taskPageDetail updateTask");
        System.out.println("param : "+taskViewFormData);

        Task entity = taskService.findById(taskViewFormData.getId());

        if(!ApplicationUtil.isStringNullOrEmpty(taskViewFormData.getType()) ||
                !ApplicationUtil.isStringNullOrEmpty(taskViewFormData.getStatement())){
            return "redirect:/task/"+taskViewFormData.getId()+"/detail?error="+ ConstantAplication.INVALID_INPUT_FORM;
        }


        entity.setType(taskViewFormData.getType());
        entity.setStatus(taskViewFormData.getStatus());

        // validation statement
        if(taskViewFormData.getStatement().equalsIgnoreCase(StatementType.Closed.toString())){
            entity.setDone(true);
            entity.setStatus(100);
            entity.setEndDate(new Date());
        }

        entity.setStatement(statementService.findByName(taskViewFormData.getStatement()));
        entity.setStartDate(taskViewFormData.getStartDate());
        entity.setEndDate(taskViewFormData.getEndDate());




        taskService.update(entity);

        return "redirect:/task/"+taskViewFormData.getId()+"/detail";
    }


    @RequestMapping(value = "/task/{taskid}/attachment/file/upload", method = RequestMethod.POST)
    public String addTaskAttachment(@RequestParam("file") MultipartFile myFile,@PathVariable("taskid") Long taskid,
                                    Principal principal, Model model) {
        System.out.println("entering addTaskAttachment");

        if(!ApplicationUtil.isStringNullOrEmpty(myFile.getOriginalFilename())){
            return "redirect:/task/"+taskid+"/detail?error="+ ConstantAplication.INVALID_INPUT_FORM;
        }
        System.out.println("file name : "+ myFile.getOriginalFilename());
        Attachment attachment = null;
        String userName = principal.getName();
        try{
            System.out.println("entering save Attachment");
            attachment =  fileService.saveAttachment(myFile, userName);
        }catch(IOException ex){
            System.out.println("error save file");
            return "redirect:/task/"+taskid+"/detail?error="+ ConstantAplication.INTERNAL_SERVER_ERROR;
        }
        System.out.println("entering add task Attachment");
        taskService.addAttachment(taskid, attachment);
        // Redirect to a successful upload page
        return "redirect:/task/"+taskid+"/detail";
    }


    @RequestMapping(value = "/task/add/comment", method = RequestMethod.POST)
    public String addCommentTask(@ModelAttribute(value="commentData") CommentFormData commentFormData,Principal principal, Model model){
        System.out.println("entering addCommentTask");
        System.out.println("param : "+ commentFormData);

        if(!ApplicationUtil.isStringNullOrEmpty(commentFormData.getMessage())){
            return "redirect:/task/"+commentFormData.getTaskId()+"/detail?error="+ ConstantAplication.INVALID_INPUT_FORM;
        }
        String username = principal.getName();
        SystemUser user = userService.findByUsername(username);
        Comment entity =  new Comment();
        entity.setMessage(commentFormData.getMessage());
        entity.setSendDate(new Date());
        entity.setUserId(user.getId());
        entity.setUserName(user.getUsername());
        if(user.getProfile().getImage() != null){
            entity.setProfileImageUserUri(user.getProfile().getImage().getFileViewUri());
        }
        taskService.addComment(commentFormData.getTaskId(), entity);
        return "redirect:/task/"+commentFormData.getTaskId()+"/detail";
    }

}
