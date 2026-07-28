package com.springboot.restaurant.modules.cart.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CartDetailId implements Serializable {

    @Column(name = "ma_gio_hang")
    private Long maGioHang;

    @Column(name = "ma_mon_an")
    private Long maMonAn;

    public CartDetailId() {
    }

    public CartDetailId(Long maGioHang, Long maMonAn) {
        this.maGioHang = maGioHang;
        this.maMonAn = maMonAn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maGioHang == null) ? 0 : maGioHang.hashCode());
        result = prime * result + ((maMonAn == null) ? 0 : maMonAn.hashCode());
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
        CartDetailId other = (CartDetailId) obj;
        if (maGioHang == null) {
            if (other.maGioHang != null)
                return false;
        } else if (!maGioHang.equals(other.maGioHang))
            return false;
        if (maMonAn == null) {
            if (other.maMonAn != null)
                return false;
        } else if (!maMonAn.equals(other.maMonAn))
            return false;
        return true;
    }
    
}