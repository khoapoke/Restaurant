package com.springboot.restaurant.modules.menu.dto.response;

public class FoodResponse {
    
    private Long maMonAn;
    private String tenMonAn;
    private double giaTien;
    private String moTa;
    private String hinhAnh;
    public FoodResponse() {
    }

    public FoodResponse(Long maMonAn, String tenMonAn, double giaTien, String moTa, String hinhAnh) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }
    
    public Long getMaMonAn() {
        return maMonAn;
    }
    public void setMaMonAn(Long maMonAn) {
        this.maMonAn = maMonAn;
    }
    public String getTenMonAn() {
        return tenMonAn;
    }
    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }
    public double getGiaTien() {
        return giaTien;
    }
    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
    
    
    
    
}
