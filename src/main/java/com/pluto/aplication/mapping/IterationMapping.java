package com.pluto.aplication.mapping;

import com.pluto.aplication.model.dto.IterationData;
import com.pluto.aplication.model.dto.form.IterationFormData;
import com.pluto.aplication.model.entity.Iteration;
import com.pluto.aplication.model.entity.Task;
import org.springframework.expression.ParseException;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by jose eduardo on 3/21/2020.
 */
public class IterationMapping {

    /**
     *
     * @param iterationFormData
     * @return
     */
    public static Iteration convertToFormDto(IterationFormData iterationFormData){

        Iteration entity = new Iteration();
        entity.setName(iterationFormData.getName());
        entity.setDescription(iterationFormData.getDescription());
        entity.setCreationDate(new Date());
        entity.setEndDate(iterationFormData.getEndDate());
        entity.setInitDate(iterationFormData.getInitDate());
        entity.setActive(true);

        return entity;
    }

    public static IterationData convertToFormDto(Iteration entity , List<Task> totalTask){

        IterationData data = new IterationData();
        int completeTask = 0;
        int pendingTask = 0;
        for(Task indeTask : totalTask){
            if(indeTask.isDone()){
                completeTask++;
            }else{
                pendingTask++;
            }
        }

        data.setId(entity.getId());
        data.setName(entity.getName());
        data.setDescription(entity.getDescription());
        data.setIniDate(entity.getInitDate());
        data.setEndDate(entity.getEndDate());

        Long remain = calculateDayBetwenDates(entity.getInitDate(),entity.getEndDate());
        data.setDayRemain(remain);
        data.setTotalTask(totalTask.size());
        data.setCompleteTask(completeTask);
        data.setPendingTask(pendingTask);

        return data;
    }

    private static Long calculateDayBetwenDates(Date first, Date second){
        long diff = 0;
        try {
            diff = second.getTime() - first.getTime();
            diff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

}
