package com.springboot.restaurant.modules.cart.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private Long maGioHang;

    private String tenKhachHang;

    private String email;

    private LocalDateTime ngayTao;

}
