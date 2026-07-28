package com.springboot.restaurant.modules.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "THANH_TOAN")
@Getter
@Setter
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_thanh_toan")
    
    private Long maThanhToan;
    @Column(name = "so_tien",nullable = false)
    private Double soTien;
    @Column(name = "phuong_thuc",length = 50)
    private String phuongThuc;
    @Column(name = "trang_thai",length = 50)
    private String trangThai;
    @OneToOne
    @JoinColumn(name = "ma_don_hang",unique = true, referencedColumnName = "ma_don_hang")
    private Order donHang;
    
    
    
}
