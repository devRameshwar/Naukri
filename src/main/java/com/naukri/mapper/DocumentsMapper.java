package com.naukri.mapper;

import com.naukri.model.Documents;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentsMapper {

    private final Logger LOGGER = LoggerFactory.getLogger(DocumentsMapper.class);

    @Transactional
    public List<Documents> setDataToEntity(MultipartFile[] multipartFile) {
        
        ArrayList<Documents> documentList = new ArrayList<>();

        for (MultipartFile file : multipartFile) {
            documentList.add(this.setEntity(file));
            LOGGER.info("set file in for loop: ");
        }
        LOGGER.info("*********Document mapper class: " + documentList);
        return documentList;
    }

    private Documents setEntity(MultipartFile multipartFile) {
        Documents documents = Documents.builder().docName(multipartFile.getOriginalFilename())
                .mimeType(multipartFile.getContentType()).size(multipartFile.getSize())
                .hash(multipartFile.getName()).build();
        return documents;
    }
}
