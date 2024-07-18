package com.naukri.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserNotFoundException extends RuntimeException {
     public static final Integer serialNumber=123124_12;
     public String massage;
}
