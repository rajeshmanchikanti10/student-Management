package com.example.demo.enums;

public enum ErrorCode {
    FORBIDDEN(403),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    CREATION_ERROR(400),
    UPDATION_ERROR(400),
    HTTP_CALL_ERROR(500);
    int responseCode;
    private ErrorCode(int code){
        this.responseCode = code;
    }
    public int getResponseCode(){
        return responseCode;
    }
}
