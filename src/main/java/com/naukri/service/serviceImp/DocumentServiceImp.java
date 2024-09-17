package com.naukri.service.serviceImp;

import com.naukri.constant.ApplicationConstant;
import com.naukri.dbHelper.DocumentDbHelper;
import com.naukri.exception.DocumentsEmptyException;
import com.naukri.exception.SomethingWentWrongException;
import com.naukri.mapper.DocumentsMapper;
import com.naukri.model.Documents;
import com.naukri.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DocumentServiceImp implements DocumentService {

    private final Logger LOGGER = LoggerFactory.getLogger(DocumentServiceImp.class);

    @Autowired
    private DocumentsMapper mapper;
    @Autowired
    private DocumentDbHelper dbHelper;

    @Override
    public String documentSave(MultipartFile[] multipartFile) {
        LOGGER.info("********* Document Service  Method called ");
        if (multipartFile.length == 0) {
            LOGGER.info("*********File is empty");
            throw new DocumentsEmptyException(ApplicationConstant.DOCUMENTS_IS_EMPTY);
        } else {
            List<Documents> documents = mapper.setDataToEntity(multipartFile);
            LOGGER.info("*******set data in Entity: "+documents);
            if (documents == null) {
                LOGGER.info("********set Data Entity is Empty");
                throw new SomethingWentWrongException(ApplicationConstant.SOMETHING_WENT_WRONG);
            } else {
                List<Documents> saveDocuments = dbHelper.saveDocuments(documents);
                LOGGER.info("********Save data in database: "+saveDocuments);
                if (saveDocuments == null) {
                    LOGGER.info("******** Repository is not save data");
                    throw new SomethingWentWrongException(ApplicationConstant.SOMETHING_WENT_WRONG);
                } else {
                    return "Documents are save";
                }
            }
        }
    }
}
