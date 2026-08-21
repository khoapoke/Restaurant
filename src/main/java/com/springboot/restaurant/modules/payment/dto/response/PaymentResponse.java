package com.springboot.restaurant.modules.payment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private Long maThanhToan;

    private Double soTien;

    private String phuongThuc;

    private String trangThai;

    private Long maDonhang;

   

}
