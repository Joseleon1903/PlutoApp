package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.Attachment;
import com.pluto.aplication.model.entity.ImagesData;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jose eduardo on 3/26/2020.
 */
public interface FileService {

    ImagesData createImage(MultipartFile file) throws IOException;

    ImagesData findById(long id);

    Resource loadFileAsResource(String fileName);

    Attachment saveAttachment(MultipartFile file, String userName) throws IOException;
}
