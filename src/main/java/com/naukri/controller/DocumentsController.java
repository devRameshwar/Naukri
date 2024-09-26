package com.naukri.controller;

import com.naukri.responce.GetAllMultipartFileClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentsController {

     ResponseEntity<String> documentSave(MultipartFile[] multipartFile);

     ResponseEntity<List<GetAllMultipartFileClass>> getDocuments();
}
