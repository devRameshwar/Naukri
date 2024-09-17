package com.naukri.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentsController {

     ResponseEntity<String> documentSave(MultipartFile[] multipartFile);
}
