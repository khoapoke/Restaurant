
package com.springboot.restaurant.modules.users.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAI_KHOAN")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_tai_khoan")
    private Long maTaiKhoan;

    @Column(name = "ten_dang_nhap", nullable = false, unique = true, length = 50)
    private String tenDangNhap;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "mat_khau", nullable = false, length = 255)
    private String matKhau;

    @Column(name = "trang_thai", length = 100)
    private String trangThai;

    @ManyToOne(fetch = FetchType.LAZY) // nhiều tài khoản thuộc về 1 vai trò
    @JoinColumn(name = "ma_nguoi_dung")
    private User nguoiDung;

    @ManyToOne(fetch = FetchType.LAZY) // nhiều tài khoản thuộc về 1 vai trò
    @JoinColumn(name = "ma_vai_tro")
    private Role vaiTro;

    // @OneToMany(mappedBy = "taiKhoan",cascade = CascadeType.ALL)
    // private List<Order> danhSachDonHang;

    // @OneToMany(mappedBy = "taiKhoan",cascade = CascadeType.ALL)
    // private List<TableReservation> danhSachDatBan;

}
