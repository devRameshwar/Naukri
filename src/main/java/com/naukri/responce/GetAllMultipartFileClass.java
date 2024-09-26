package com.naukri.responce;

import com.naukri.model.Documents;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class GetAllMultipartFileClass extends Documents implements Serializable {
    public GetAllMultipartFileClass(Documents document) {
        super.setDocId(document.getDocId());
        super.setDocName(document.getDocName());
        super.setMimeType(document.getMimeType());
        super.setSize(document.getSize());
        super.setHash(document.getHash());
    }
}
