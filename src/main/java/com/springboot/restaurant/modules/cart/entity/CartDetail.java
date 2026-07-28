package com.springboot.restaurant.modules.cart.entity;



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
@Table(name = "CHI_TIET_GIO_HANG")
@Getter
@Setter
public class CartDetail {

    @EmbeddedId
    private CartDetailId cartDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maGioHang") // map 'maGioHang' in CartDetailId
    @JoinColumn(name = "ma_gio_hang")
    private Cart gioHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maMonAn") // map 'mapMonAn' in CartDetailId
    @JoinColumn(name = "ma_mon_an")
    private Food monAn;

    @Column(name = "so_luong", nullable = false)
    private Integer soLuong;

    @Column(name = "don_gia", nullable = false)
    private Double donGia;

    public CartDetail() {
    }

    public CartDetail(CartDetailId cartDetailId, Cart gioHang, Food monAn, Integer soLuong, Double donGia) {
        this.cartDetailId = cartDetailId;
        this.gioHang = gioHang;
        this.monAn = monAn;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
}