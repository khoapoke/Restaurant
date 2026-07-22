package com.springboot.restaurant.modules.users.dto.response;

public class UserCreateResponse {

    private String tenDangNhap;
    private String email;

    private String matKhau;
    

    public UserCreateResponse() {
    }


    public UserCreateResponse(String tenDangNhap, String matKhau,String email) {
        
        
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
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
