package com.naukri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<String> userAlreadyExists(UserAlreadyExists e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(SomethingWentWrongException.class)
    public ResponseEntity<String > somethingWentWrong(SomethingWentWrongException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
