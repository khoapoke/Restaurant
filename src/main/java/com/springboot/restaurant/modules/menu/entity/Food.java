package com.springboot.restaurant.modules.menu.entity;

import java.util.List;

import com.springboot.restaurant.modules.cart.entity.CartDetail;
import com.springboot.restaurant.modules.order.entity.OrderDetail;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MON_AN")
@Getter
@Setter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_mon_an")
    private Long maMonAn;

    @Column(name = "ten_mon_an", nullable = false, length = 100)
    private String tenMonAn;
    @Column(name = "gia_tien", nullable = false)
    private Double giaTien;
    @Column(name = "mo_ta", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;
    @Column(name = "hinh_anh", length = 255)
    private String hinhAnh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_danh_muc")
    private FoodCategory danhMuc;
    
    
    // only maintain a list of week entities
    @OneToMany(mappedBy = "monAn",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartDetail> danhSachChiTietGioHang;
    
    @OneToMany(mappedBy = "monAn",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderDetail> danhSachChiTietDonHang;

    public Food() {
    }

    public Food(Long maMonAn, String tenMonAn, Double giaTien, String moTa, String hinhAnh, FoodCategory danhMuc) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.danhMuc = danhMuc;
    }
}