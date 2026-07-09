package com.springboot.restaurant.modules.users.dto.response;

public class UserCreationResponse {

    private String tenDangNhap;
    private String email;
 

    private String matKhau;
    

    public UserCreationResponse() {
    }


    public UserCreationResponse(String tenDangNhap, String matKhau) {
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
