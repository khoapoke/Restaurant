package com.springboot.restaurant.modules.order.entity;


import com.springboot.restaurant.modules.menu.entity.Food;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "CHI_TIET_DON_HANG")
@Getter
@Setter

public class OrderDetail {
    
    @EmbeddedId
    private OrderDetailId orderDetailId;
    
    @MapsId("maDonHang") // map 'maDonHang' in OrderDetailId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ma_don_hang")
    private Order donHang;
    
    
    @MapsId("maMonAn") // map 'maMonAn' in OrderDetailId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_mon_an")
    private Food monAn;
    
    @Column(name = "so_luong")
    private Integer soLuong;
    
    @Column(name = "don_gia",nullable = false)
    private Double donGia;
    
    
    
    
}
