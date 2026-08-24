package com.springboot.restaurant.modules.cart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {
    
    private Long maMonAn;
    
    private String tenMonAn;
    
    private Integer soLuong;
    
    private Double donGia;
    
    
}
