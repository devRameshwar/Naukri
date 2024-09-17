package com.naukri.dbHelper;

import com.naukri.model.Documents;
import com.naukri.repository.DocumentsRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentDbHelperImp implements DocumentDbHelper  {

    private final Logger LOGGER= LoggerFactory.getLogger(DocumentDbHelperImp.class);

    @Autowired
    private DocumentsRepository repository;

    @Override
    @Transactional
    public List<Documents> saveDocuments(List<Documents> documents) {
        LOGGER.info("Repository save method called : "+documents);
        return repository.saveAll(documents);
    }
}
