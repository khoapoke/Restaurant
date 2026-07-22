package com.springboot.restaurant.modules.users.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserCreationRequest {

    
    @Size(min = 3, message="username must be at least 3 characters")
    private String tenDangNhap;
    @Email(message = "email not formatted")
    private String email;
    @Size(min = 4, message="Passwors must be at least 4 characters")
    private String matKhau;

    public UserCreationRequest() {
    }

    public UserCreationRequest( String tenDangNhap, String matKhau) {
        
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }


   
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

}
