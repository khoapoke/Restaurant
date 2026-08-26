package com.springboot.restaurant.modules.order.entity;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailId implements Serializable {

    @Column(name = "ma_don_hang")
    private Long maDonHang;

    @Column(name = "ma_mon_an")
    private Long maMonAn;

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maDonHang == null) ? 0 : maDonHang.hashCode());
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
        OrderDetailId other = (OrderDetailId) obj;
        if (maDonHang == null) {
            if (other.maDonHang != null)
                return false;
        } else if (!maDonHang.equals(other.maDonHang))
            return false;
        if (maMonAn == null) {
            if (other.maMonAn != null)
                return false;
        } else if (!maMonAn.equals(other.maMonAn))
            return false;
        return true;
    }
    
    
}