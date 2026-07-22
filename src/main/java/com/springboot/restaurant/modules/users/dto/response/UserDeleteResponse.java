package com.springboot.restaurant.modules.users.dto.response;

public class UserDeleteResponse {
    
    private Long maTaiKhoan;
    private String tenDangNhap;
    private String email;
    private String hoTen;
    
    public UserDeleteResponse(){}

    public UserDeleteResponse(Long maTaiKhoan, String tenDangNhap, String email, String hoTen) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.email = email;
        this.hoTen = hoTen;
    }

    public Long getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(Long maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    
    
}
