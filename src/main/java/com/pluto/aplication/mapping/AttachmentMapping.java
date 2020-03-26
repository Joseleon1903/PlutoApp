package com.pluto.aplication.mapping;

import com.pluto.aplication.model.dto.AttachmentData;
import com.pluto.aplication.model.dto.form.IterationFormData;
import com.pluto.aplication.model.entity.Attachment;
import com.pluto.aplication.model.entity.Iteration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jose eduardo on 3/26/2020.
 */
public class AttachmentMapping {

    private AttachmentMapping(){}

    public static List<AttachmentData>  convertToFormDtoList(List<Attachment> entityList){

        List<AttachmentData> listData = new ArrayList<>();
        if(entityList != null){
            entityList.forEach( entity ->{
                AttachmentData data = new AttachmentData();
                data.setId(entity.getId());
                data.setFileName(entity.getFileName());
                data.setFileDetail(entity.getFileDetail());
                data.setDocumentType(entity.getDocumentType());
                data.setDownloadUri(entity.getDownloadUri());
                data.setUploadDate(entity.getUploadDate());
                data.setViewUri(entity.getViewUri());
                data.setUserName(entity.getUserName());
                listData.add(data);
            });
        }
        return listData;
    }



}
