package com.example.demo.exceptions;

import com.example.demo.enums.ErrorCode;

public class StudentException extends RuntimeException{
    private final  int httpStatusCode;
    private final ErrorCode errorCode;
    private final String Message;

    public StudentException(ErrorCode errorCode,String message) {
        this.errorCode = errorCode ;
        this.httpStatusCode = errorCode.getResponseCode();
        Message = message;
    }
    public int getHttpStatusCode(){
        return httpStatusCode;
    }
    public String getMessage(){
        return Message;
    }
}
