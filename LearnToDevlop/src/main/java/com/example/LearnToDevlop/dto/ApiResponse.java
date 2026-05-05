package com.example.LearnToDevlop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse <T>(boolean success, String message,T data) {
    public static <T> ApiResponse<T> ok(String msg, T data) {
        return new ApiResponse<>(true, msg, data);

    }
    public static <T> ApiResponse fail(String msg) {
        return new ApiResponse(true, msg, null);

    }
}
