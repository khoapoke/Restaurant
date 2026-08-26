package com.springboot.restaurant.modules.tablerestaurant.entity;

import com.springboot.restaurant.modules.users.entity.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "CHI_TIET_DAT_BAN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TableReservationDetail {

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ma_dat_ban")
    private TableReservation datBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ma_tai_khoan")
    private Account taiKhoan;

}
