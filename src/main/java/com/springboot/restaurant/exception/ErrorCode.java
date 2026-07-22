package com.springboot.restaurant.exception;

public enum ErrorCode {
    
    
    
    USER_NOT_FOUND(1050, "User not found in system"),
    EMAIL_EXISTED(1022, "Email already exists"),
    INVALID_KEY(9999, "Uncategorized error"),
    TENDANGNHAP_EXISTED(1022,"User name already exists");
    
    
    
    
    
    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
    
    
}
