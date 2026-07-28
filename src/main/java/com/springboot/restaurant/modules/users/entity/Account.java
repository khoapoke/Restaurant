
package com.springboot.restaurant.modules.users.entity;


import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
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
@Entity
@Table(name = "TAI_KHOAN")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_tai_khoan")
    private Long maTaiKhoan;

    @Column(name = "ten_dang_nhap", nullable = false, unique = true, length = 50)
    private String tenDangNhap;

    @Column(name = "mat_khau", nullable = false, length = 255)
    private String matKhau;

    @Column(name = "ho_ten", nullable = false, length = 100)
    private String hoTen;

    @Column(name = "ngay_sinh")

    private LocalDate ngaySinh;

    @Column(name = "dia_chi", length = 255)
    private String diaChi;
    @Column(name = "email", length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY) // nhiều tài khoản thuộc về 1 vai trò
    @JoinColumn(name = "ma_vai_tro")
    private Role vaiTro;

    // @OneToMany(mappedBy = "taiKhoan",cascade = CascadeType.ALL)
    // private List<Order> danhSachDonHang;
    
    // @OneToMany(mappedBy = "taiKhoan",cascade = CascadeType.ALL)
    // private List<TableReservation> danhSachDatBan;
    
    public Account() {

    }

    public Account(Account object) {
        this.maTaiKhoan = object.maTaiKhoan;
        this.tenDangNhap = object.tenDangNhap;
        this.matKhau = object.matKhau;
        this.hoTen = object.hoTen;
        this.ngaySinh = object.ngaySinh;
        this.diaChi = object.diaChi;
        this.email = object.email;
        this.vaiTro = object.vaiTro;
    }


}
