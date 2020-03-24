package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.dto.SummaryData;
import com.pluto.aplication.model.entity.Iteration;
import com.pluto.aplication.model.entity.Project;
import com.pluto.aplication.model.entity.Task;
import com.pluto.aplication.repository.IterationRepository;
import com.pluto.aplication.repository.ProjectRepository;
import com.pluto.aplication.repository.TaskRepository;
import com.pluto.aplication.service.interfaces.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/24/2020.
 */
@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IterationRepository iterationRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<SummaryData> searchResumenByParam(String projectName, String iterationName) {

        List<SummaryData> dataout = new ArrayList<>();

        Project project = projectRepository.findByName(projectName);

        List<Iteration> listiteration = iterationRepository.findByProjectIdOrderById(project.getId());

        listiteration.forEach( iteration -> {
            List<Task> taskList = taskRepository.findByIterationName(iteration.getName());
            taskList.forEach(task ->{
                SummaryData summaryData = new SummaryData();
                summaryData.setTaskTittle(task.getTaskTittle());
                summaryData.setTaskDetail(task.getTaskDetail());
                summaryData.setDone(task.isDone());
                summaryData.setNote(task.getNote());
                summaryData.setPriority(task.getPriority().getValue());
                summaryData.setStatus(task.getStatus());
                summaryData.setType(task.getType());
                summaryData.setIterationId(iteration.getId());
                summaryData.setTaskId(task.getId());
                dataout.add(summaryData);
            });
        });
        return dataout;
    }
}
