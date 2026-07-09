package com.springboot.restaurant.shared;

import java.time.LocalDateTime;




// thêm chú thích để hiển thị các trường bị null

public class ApiResponse<T> {

    private boolean success;
    private int status;
    private String message;
    private T data;
    private Object errors;
    private LocalDateTime timestamp;

    public ApiResponse() {

    }

    public ApiResponse(boolean success, int status, String message, T data, Object errors, LocalDateTime timestamp) {
        this.success = success;
        this.status = status;
        this.message = message;
        this.data = data;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // static method

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(
                true,
                200,
                message,
                data,
                null,
                LocalDateTime.now()

        );

    }

    public static <T> ApiResponse<T> created(String message, T data) {
        return new ApiResponse<>(
                true,
                201,
                message,
                data,
                null,
                LocalDateTime.now()

        );
    }

    public static <T> ApiResponse<T> error(int status, String message, Object errors) {
        return new ApiResponse<>(
                false,
                status,
                message,
                null,
                errors,
                LocalDateTime.now()

        );
    }
    
    
    

}