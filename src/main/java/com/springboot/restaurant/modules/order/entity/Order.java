package com.springboot.restaurant.modules.order.entity;

import com.springboot.restaurant.modules.users.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DON_HANG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang")
    private Long maDonHang;
    @Column(name = "ngay_dat_hang")
    private LocalDateTime ngayDatHang;
    @Column(name = "tong_tien")
    private Double tongTien;
    @Column(name = "trang_thai", length = 50)
    private String trangThai;
    @Column(name = "dia_chi_giao_hang", length = 255)
    private String diaChiGiaoHang;

    // onwing side
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_tai_khoan")
    private Account taiKhoan;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> danhSachChiTietDonHang = new ArrayList<>();

    public void addOrderDetail(OrderDetail orderDetail) {
        danhSachChiTietDonHang.add(orderDetail);
        orderDetail.setDonHang(this);
        this.tongTien = calculateTotalOrderItems();

    }

    public void removeOrderDetail(OrderDetail orderDetail) {
        danhSachChiTietDonHang.remove(orderDetail);
        orderDetail.setDonHang(null);
        this.tongTien = calculateTotalOrderItems();

    }

    public Double calculateTotalOrderItems() {
        Double total = 0.0;

        for (OrderDetail orderDetail : danhSachChiTietDonHang) {

            total += orderDetail.getDonGia() * orderDetail.getSoLuong();

        }

        return total;
    }

}
