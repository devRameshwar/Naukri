package com.naukri.service;

import com.naukri.responce.GetAllMultipartFileClass;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    String documentSave(MultipartFile[] multipartFile);

    List<GetAllMultipartFileClass> getDocuments();
}
