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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MON_AN_GIO_HANG")
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

    // @Column(name = "don_gia", nullable = false)
    // private Double donGia;

 
}