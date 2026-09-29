package com.springboot.restaurant.modules.user.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NGUOI_DUNG")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nguoi_dung")
    private Long maNguoiDung;
    @Column(name = "ho_ten", length = 100)
    private String hoTen;
    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;
    @Column(name = "dia_chi",length = 255)
    private String diaChi;
    @Column(name = "so_dien_thoai",length = 20)
    private String sdt;

}
