package com.example.demo.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentResponse<T> {
    private T data;
    private boolean success = false;

}
