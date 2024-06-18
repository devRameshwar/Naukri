package com.naukri.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode (callSuper = false)
public class UserAlreadyExists extends RuntimeException{

    private String message;
    private static final Integer serialNumber= 123_456;

}
