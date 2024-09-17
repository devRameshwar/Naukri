package com.naukri.service.serviceImp;

import com.naukri.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentServiceImp implements DocumentService {

    private final Logger LOGGER= LoggerFactory.getLogger(DocumentServiceImp.class);

    @Override
    public String documentSave(MultipartFile[] multipartFile) {
        LOGGER.info("********* Document Service  Method called " );


        return "";
    }
}
