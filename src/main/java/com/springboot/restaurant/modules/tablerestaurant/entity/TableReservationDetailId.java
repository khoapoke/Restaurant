package com.springboot.restaurant.modules.tablerestaurant.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class TableReservationDetailId implements Serializable {

    @Column(name = "ma_dat_ban")
    private Long maDatBan;

    @Column(name = "ma_tai_khoan")
    private Long maTaiKhoan;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maDatBan == null) ? 0 : maDatBan.hashCode());
        result = prime * result + ((maTaiKhoan == null) ? 0 : maTaiKhoan.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TableReservationDetailId other = (TableReservationDetailId) obj;
        if (maDatBan == null) {
            if (other.maDatBan != null)
                return false;
        } else if (!maDatBan.equals(other.maDatBan))
            return false;
        if (maTaiKhoan == null) {
            if (other.maTaiKhoan != null)
                return false;
        } else if (!maTaiKhoan.equals(other.maTaiKhoan))
            return false;
        return true;
    }

}
