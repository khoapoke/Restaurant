package com.springboot.restaurant.modules.cart.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.springboot.restaurant.modules.users.entity.Account;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "GIO_HANG")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_gio_hang")
    private Long maGioHang;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;

    // Redundant attribute in the db, need refactor db
    // @Column(name = "da_thanh_toan")
    // private Boolean daThanhToan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_tai_khoan", referencedColumnName = "ma_tai_khoan", unique = true)
    private Account taiKhoan;

    @OneToMany(mappedBy = "gioHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartDetail> danhSachChiTietGioHang = new ArrayList<>();

    public void addCartitem(CartDetail cartDetail) {

        danhSachChiTietGioHang.add(cartDetail);
        cartDetail.setGioHang(this);

    }

    public void removeCartItem(CartDetail cartDetail) {
        danhSachChiTietGioHang.remove(cartDetail);
        cartDetail.setGioHang(null);
    }
}