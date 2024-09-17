package com.naukri.controller.controllerImp;

import com.naukri.controller.DocumentsController;
import com.naukri.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
@RestController
@RequestMapping(path = "/documents")
public class DocumentsControllerImp implements DocumentsController {

    private final Logger LOGGER= LoggerFactory.getLogger(DocumentsControllerImp.class);

    @Autowired
    private DocumentService service;

    @Override
    @RequestMapping(path = "/add",method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<String> documentSave(@RequestParam(value = "document") MultipartFile[] multipartFile) {
        LOGGER.info("****** MultipartFile: "+ Arrays.toString(multipartFile));
        return ResponseEntity.ok(service.documentSave(multipartFile));
    }
}
