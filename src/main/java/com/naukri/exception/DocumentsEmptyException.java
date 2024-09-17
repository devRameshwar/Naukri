package com.naukri.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DocumentsEmptyException extends RuntimeException {

    private static final Integer serialNumber=345678_6;
    private String message;

}
