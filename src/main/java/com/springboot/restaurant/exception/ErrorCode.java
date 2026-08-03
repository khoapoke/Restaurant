package com.springboot.restaurant.exception;

public enum ErrorCode {
    
    
    
    USER_NOT_FOUND(404, "User not found in system"),
    EMAIL_EXISTED(409, "Email already exists"),
    INVALID_KEY(409, "Uncategorized error"),
    TENDANGNHAP_EXISTED(409, "User name already exists"),
    
    ROLE_EXISTED(409, "role already existed"),
    ROLE_NOT_FOUND(404, "role has not been create");
    
    
    
    
    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
    
    
}
