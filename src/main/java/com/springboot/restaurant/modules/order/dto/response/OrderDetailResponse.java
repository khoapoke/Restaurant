package com.springboot.restaurant.modules.order.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {

    private Long maDonHang;

    private String tenKhachHang;

    private LocalDateTime ngayDatHang;

    private Double tongTien;

    private String trangThai;

    private String diaChiGiaoHang;

    private List<OrderItemResponse> danhSachMonAn;

}
