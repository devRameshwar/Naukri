package com.naukri.dbHelper;

import com.naukri.model.Documents;

import java.util.List;

public interface DocumentDbHelper {
    List<Documents> saveDocuments(List<Documents> documents);

    List<Documents> getDucuments();

}
