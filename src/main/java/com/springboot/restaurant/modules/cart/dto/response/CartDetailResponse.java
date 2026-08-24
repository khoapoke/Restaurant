package com.springboot.restaurant.modules.cart.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailResponse {

    private Long maGioHang;

    private Long maTaiKhoan;

    private String tenKhachHang;

    private LocalDateTime ngayTao;
    
    private List<CartItemResponse> danhSachMonAn = new ArrayList<>();

}
