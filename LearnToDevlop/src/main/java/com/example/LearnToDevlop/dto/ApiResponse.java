package com.example.LearnToDevlop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(boolean success, String message, T data) {

    public static <T> ApiResponse<T> ok(String msg, T data) {
        return new ApiResponse<>(true, msg, data);
    }

    public static <T> ApiResponse<T> ok(String msg) {
        return new ApiResponse<>(true, msg, null);
    }

    public static <T> ApiResponse<T> fail(String msg) {
        return new ApiResponse<>(false, msg, null);
    }
}
