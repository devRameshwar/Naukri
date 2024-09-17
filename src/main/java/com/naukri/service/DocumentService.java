package com.naukri.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
    String documentSave(MultipartFile[] multipartFile);

}
