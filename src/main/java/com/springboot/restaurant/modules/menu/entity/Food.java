package com.springboot.restaurant.modules.menu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MON_AN")
public class Food {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_mon_an")
    private Long maMonAn;
    
    @Column(name = "ten_mon_an", nullable = false,length = 100)
    private String tenMonAn;
    @Column(name = "gia_tien", nullable = false)
    private double giaTien;
    @Column(name = "mo_ta", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;
    @Column(name = "hinh_anh",length = 255)
    private String hinhAnh;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_danh_muc")
    private Catagories maDanhMuc;

    public Food() {
    }

    public Food(Long maMonAn, String tenMonAn, double giaTien, String moTa, String hinhAnh, Catagories maDanhMuc) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.maDanhMuc = maDanhMuc;
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

    public Catagories getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Catagories maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    } 
    
    
}
