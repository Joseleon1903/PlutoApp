package com.pluto.aplication.mapping;

import com.pluto.aplication.model.dto.AttachmentData;
import com.pluto.aplication.model.dto.CommentData;
import com.pluto.aplication.model.entity.Attachment;
import com.pluto.aplication.model.entity.Comment;
import com.pluto.aplication.model.entity.SystemUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose eduardo on 3/26/2020.
 */
public class CommentMapping {

    private CommentMapping(){}

    public static List<CommentData> convertToFormDtoList(List<Comment> entityList){

        List<CommentData> listData = new ArrayList<>();
        if(entityList != null){
            entityList.forEach( entity ->{
                CommentData data = new CommentData();
                data.setId(entity.getId());
                data.setMessage(entity.getMessage());
                data.setProfileUrl("");
                data.setSendDate(entity.getSendDate());
                data.setUserName(entity.getUserName());
                data.setProfileUrl(entity.getProfileImageUserUri());
                listData.add(data);
            });
        }
        return listData;
    }


}
