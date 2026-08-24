package com.springboot.restaurant.modules.cart.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemCreateRequest {


    private Long maMonAn;

    private Integer soLuong;
}
