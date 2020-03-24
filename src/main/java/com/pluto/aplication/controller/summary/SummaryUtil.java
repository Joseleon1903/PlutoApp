package com.pluto.aplication.controller.summary;

import com.pluto.aplication.model.entity.Iteration;
import com.pluto.aplication.model.entity.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/24/2020.
 */
public class SummaryUtil {

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



}
