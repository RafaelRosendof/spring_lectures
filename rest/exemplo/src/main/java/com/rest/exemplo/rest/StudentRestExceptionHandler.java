package com.rest.exemplo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler{
    @ExceptionHandler
    public ResponseEntity<StudentErroResponse> handleException(StudentNotFoundException e){
        //criar student erro response e retornar 
        StudentErroResponse erro = new StudentErroResponse();
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setMessage(e.getMessage());
        erro.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(erro , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErroResponse> handleException(Exception e){
        StudentErroResponse erro = new StudentErroResponse();
        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setMessage(e.getMessage());
        erro.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(erro , HttpStatus.BAD_REQUEST);
    }
}