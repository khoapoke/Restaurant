package com.springboot.restaurant.modules.tableReservation.entity;

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
@Table(name = "BAN_AN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TableRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ban")
    private Long maBan;
    @Column(name = "ten_ban", nullable = false, length = 50)
    private String tenBan;
    @Column(name = "suc_chua")
    private Integer sucChua;
    @Column(name = "trang_thai", length = 50)
    private String trangThai;
    @Column(name = "vi_tri", length = 100)
    private String viTri;

    // @OneToMany(mappedBy = "ban",cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<TableReservation> danhSachDatBan;

}