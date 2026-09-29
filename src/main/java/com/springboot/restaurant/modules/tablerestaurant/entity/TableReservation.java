package com.springboot.restaurant.modules.tablerestaurant.entity;

import java.time.LocalDateTime;

import com.springboot.restaurant.modules.user.entity.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "DAT_BAN")
public class TableReservation {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dat_ban")
    private Long maDatBan;
    @Column(name ="thoi_gian",nullable = false )
    private LocalDateTime thoiGian;
    @Column(name = "so_luong_khach")
    private Integer soLuongKhach;
    @Column(name = "trang_thai",length = 50)
    private String trangThai;
    @Column(name = "ghi_chu",columnDefinition = "NVARCHAR(MAX)")
    private String ghiChu;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_tai_khoan")
    private Account taiKhoan;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_ban")
    private TableRestaurant ban;
    
    
}
