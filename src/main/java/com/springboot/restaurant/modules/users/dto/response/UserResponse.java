package com.springboot.restaurant.modules.users.dto.response;

import java.time.LocalDate;

import com.springboot.restaurant.modules.users.entity.Role;

public class UserResponse {
    
    private Long maTaiKhoan;
    
    private String hoTen;

    private LocalDate ngaySinh;

    private String diaChi;

    private String email;
    
    private Role vaiTro;
    
    
    public UserResponse() {
    }

    public UserResponse(Long maTaiKhoan, String hoTen, LocalDate ngaySinh, String diaChi, String email,Role vaiTro) {
        this.maTaiKhoan = maTaiKhoan;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.vaiTro = vaiTro;
    }
    
  public Long getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(Long maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Role vaiTro) {
        this.vaiTro = vaiTro;
    }

  

}
