package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler
{
    // add exception handling code here

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException x)
    {

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(x.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return a ResponseEntity
        // Jackson will handle turning this into a JSON
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler for generic exceptions (should catch anything!)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception x)
    {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad Index Given, please use plain integers");
        error.setTimeStamp(System.currentTimeMillis());

        // return a ResponseEntity
        // Jackson will handle turning this into a JSON
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
