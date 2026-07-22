package com.springboot.restaurant.shared;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.restaurant.exception.FieldErrorDetail;

import java.time.LocalDateTime;
import java.util.List;




// thêm chú thích để hiển thị các trường bị null
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private int code; 
    private String message;
    private T result;
    private List<FieldErrorDetail> errors;
    private LocalDateTime timestamp;

    public ApiResponse() {
        success = true;
        code = 200;
        timestamp = LocalDateTime.now();

    }

    public ApiResponse(boolean success, int code, String message, T result, List<FieldErrorDetail> errors, LocalDateTime timestamp) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.result = result;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<FieldErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldErrorDetail> errors) {
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // static method instead of set thu cong thi chi can goi method success

    public static <T> ApiResponse<T> success(int code,String message, T result) {
        
        ApiResponse<T> apiResponse = new ApiResponse<>();
        
        
        apiResponse.setMessage(message);
        apiResponse.setSuccess(true);
        apiResponse.setCode(code);
        apiResponse.setResult(result);
        
        return apiResponse;

    }



}