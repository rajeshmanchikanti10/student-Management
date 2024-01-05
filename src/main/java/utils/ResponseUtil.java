package utils;

import com.example.demo.response.StudentResponse;

public class ResponseUtil {
    public static <T> StudentResponse<T> toResponse(T t){
        return StudentResponse.<T>builder()
                .success(true)
                .data(t)
                .build();
    }
}
