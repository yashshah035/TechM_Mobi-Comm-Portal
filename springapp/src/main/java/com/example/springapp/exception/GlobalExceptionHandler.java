package com.example.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(AddonNotFoundException.class)
    public ResponseEntity<Object> handleException(AddonNotFoundException exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(PlanNotFoundException.class)
    public ResponseEntity<Object> handleException(PlanNotFoundException exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleException(CustomerNotFoundException exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    
    
}