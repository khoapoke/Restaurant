package com.springboot.restaurant.modules.payment.entity;

import com.springboot.restaurant.modules.order.entity.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

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
@Table(name = "THANH_TOAN")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_thanh_toan")
    private Long maThanhToan;

    @Column(name = "so_tien", nullable = false)
    private Double soTien;
    @Column(name = "phuong_thuc", length = 50)
    private String phuongThuc;
    @Column(name = "trang_thai", length = 50)
    private String trangThai;
    @OneToOne
    @JoinColumn(name = "ma_don_hang", unique = true, referencedColumnName = "ma_don_hang")
    private Order donHang;
    
    public Double calculateTotalPayment() {

        Double moneyOrder = donHang.calculateTotalOrderItems();

        // add some vocher or something else

        return moneyOrder;
    }

}
