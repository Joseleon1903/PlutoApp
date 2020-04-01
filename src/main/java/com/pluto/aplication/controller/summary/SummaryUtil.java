package com.pluto.aplication.controller.summary;

import com.pluto.aplication.constant.TaskType;
import com.pluto.aplication.controller.project.ProjectDetailPageController;
import com.pluto.aplication.model.dto.SummaryData;
import com.pluto.aplication.model.entity.Iteration;
import com.pluto.aplication.model.entity.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/24/2020.
 */
public class SummaryUtil {

    Logger logger = LoggerFactory.getLogger(ProjectDetailPageController.class);

    private SummaryUtil(){}

    public static List<String> getProjectList(List<Project> projectList){
        List<String> listout = new ArrayList();
        projectList.forEach( item ->{
            listout.add(item.getName());
        });
        return listout;
    }

    public static List<String> getIterationList(List<Iteration> iterationList){
        List<String> listout = new ArrayList();
        iterationList.forEach( item ->{
            listout.add(item.getName());
        });
        return listout;
    }

    public static String generateSummaryCode(String projecName, String iterationname){

        StringBuilder builder = new StringBuilder();

        builder.append("PROJECT:"+projecName.toUpperCase());
        builder.append("-");
        builder.append(iterationname.toUpperCase());
        return builder.toString();
    }

    public static String generateSummaryPercent(List<SummaryData> sumaryData){

        Double totalTask = Double.parseDouble(sumaryData.size()+ "");
        double SumTaskPercent = 0.00;

        for (SummaryData data: sumaryData) {
            SumTaskPercent += data.getStatus();
        }
        double total = SumTaskPercent/totalTask;
        return total+"%";
    }

    public static void generateSummaryPieViewPercent(List<SummaryData> sumaryData, Model model){

        double taskPercent =0;
        double bugPercent = 0;
        double issuePercent = 0;
        double enhancementPercent = 0;

        double totalItem = Double.parseDouble(sumaryData.size()+"");

        for (SummaryData summaryData:sumaryData) {

            if(summaryData.getType().equalsIgnoreCase(TaskType.Task.toString())){
                taskPercent++;
            }

            if(summaryData.getType().equalsIgnoreCase(TaskType.Bug.toString())){
                bugPercent++;
            }

            if(summaryData.getType().equalsIgnoreCase(TaskType.Issue.toString())){
                issuePercent++;
            }

            if(summaryData.getType().equalsIgnoreCase(TaskType.Enhancement.toString())){
                enhancementPercent++;
            }
        }

        taskPercent = (taskPercent*100)/totalItem;

        bugPercent = (bugPercent*100)/totalItem;

        issuePercent = (issuePercent*100)/totalItem;

        enhancementPercent = (enhancementPercent*100)/totalItem;


        model.addAttribute("taskPercent", taskPercent);
        model.addAttribute("bugPercent", bugPercent);
        model.addAttribute("issuePercent", issuePercent);
        model.addAttribute("enhancementPercent", enhancementPercent);

    }

}
