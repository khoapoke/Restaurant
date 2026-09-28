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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CHI_TIET_DON_HANG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    @MapsId("maDonHang") // map 'maDonHang' in OrderDetailId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_don_hang")
    private Order donHang;

    @MapsId("maMonAn") // map 'maMonAn' in OrderDetailId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_mon_an")
    private Food monAn;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia", nullable = false)
    private Double donGia;

    // hàm cập nhật đơn giá từ món ăn, không lấy trực tiếp từ món ăn vì giá cũ đã đặt đươn thì không thể tự động cập nhật
    public void updateDonGiaFromMonAn() {

        if (this.monAn != null) {
            this.donGia = this.monAn.getGiaTien();
        } else {
            this.donGia = 0.0;
        }

    }



}