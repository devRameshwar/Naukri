package com.naukri.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SomethingWentWrongException extends RuntimeException{
    private String message;
    private static final Integer serialNumber= 3435_3543;

}
