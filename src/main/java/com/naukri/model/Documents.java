package com.naukri.model;

import com.naukri.responce.GetAllMultipartFileClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer-documents")
public class Documents  {

    public static final Integer RADIX = 16;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docId;

    @Column(name = "document-name")
    private String docName;

    @Column(name = "mime-type")
    private String mimeType;

    @Column(name = "size")
    private Long size;

    @Column(name = "hash")
    private String hash;

    public void setHash() throws NoSuchAlgorithmException {
        String transFormedName = this.docName + this.mimeType + this.size + new Date().getTime();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(transFormedName.getBytes(StandardCharsets.UTF_8));
        this.hash = new BigInteger(1, messageDigest.digest()).toString(RADIX);

    }


}
