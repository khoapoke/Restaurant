package com.springboot.restaurant.modules.order.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long maDonHang;

    private LocalDateTime ngayDatHang;

    private Double tongTien;

    private String trangThai;

    private String diaChiGiaoHang;

}
