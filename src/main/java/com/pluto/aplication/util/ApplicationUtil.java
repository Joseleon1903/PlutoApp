package com.pluto.aplication.util;

import com.pluto.aplication.model.dto.ErrorData;
import com.pluto.aplication.model.entity.ErrorException;
import com.pluto.aplication.service.interfaces.ErrorExceptionService;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ApplicationUtil {

    private ApplicationUtil(){}

    /**
     *  return true if Strinf is null or is empty
     * 
     * @param text
     * @return boolean 
     */
    public static boolean isStringNullOrEmpty(String text){
        if(text != null && !text.trim().isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(Object date){
        if(date != null){
            return true;
        }
        return false;
    }

    /**
     * 
     * @param beginDate
     * @return
     */
    public static String timePastFromDate(Date beginDate){
        Date currentTime =  new Date();
        long diff = currentTime.getTime() - beginDate.getTime();//as given
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff); 
        if(minutes <=0){
            return "";
        }
        return minutes+" minutes ago";
    }

    public static void validateErrorPage(String error, Model model, ErrorExceptionService errorExceptionService){
        if(ApplicationUtil.isStringNullOrEmpty(error)){
            ErrorException errorEntity = errorExceptionService.findByCode(Long.parseLong(error));
            ErrorData data = new ErrorData();
            data.setId(errorEntity.getId());
            data.setCode(errorEntity.getCode()+"");
            data.setTittle("Application server error");
            data.setDescription(errorEntity.getDescription());
            model.addAttribute("errorBean",data);

        }
    }


}