package com.scottlogic.librarygradproject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.NoSuchElementException;


//template code for global exception handling
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> exceptionHandler(Exception ex, WebRequest request){
        Object body = basicException(ex.getMessage(),HttpStatus.BAD_REQUEST,request.getDescription(false));
        return handleExceptionInternal(ex,body,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private Object basicException(String message,HttpStatus status,String path){
        LocalDateTime now = LocalDateTime.now();
        HashMap<String, String> retVal = new HashMap<>();

        retVal.put("timestamp",now.toString());
        retVal.put("status",String.valueOf(status.value()));
        retVal.put("error",status.getReasonPhrase());
        retVal.put("message",message);
        retVal.put("path",path);


        return retVal;
    }

}
