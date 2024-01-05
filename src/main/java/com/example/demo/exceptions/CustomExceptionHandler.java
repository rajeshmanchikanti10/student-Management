package com.example.demo.exceptions;

import com.example.demo.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({StudentException.class})
    public ResponseEntity<StudentResponse> studentExceptionHandler(StudentException ex) {
        StudentResponse st = StudentResponse.builder().success(false).data(ex.getMessage()).build();
        return ResponseEntity.status(ex.getHttpStatusCode()).body(st);
    }


}
