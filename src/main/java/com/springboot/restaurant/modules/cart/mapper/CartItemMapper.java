package com.springboot.restaurant.modules.cart.mapper;

import org.springframework.stereotype.Component;

import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;
import com.springboot.restaurant.modules.cart.entity.CartDetail;

@Component 
public class CartItemMapper {
    
    public CartItemResponse toCartItemResponse(CartDetail cartDetail) {

        CartItemResponse response = new CartItemResponse();

        response.setMaMonAn(cartDetail.getMonAn().getMaMonAn());
        response.setTenMonAn(cartDetail.getMonAn().getTenMonAn());
        response.setDonGia(cartDetail.getMonAn().getGiaTien());
        response.setSoLuong(cartDetail.getSoLuong());

        return response;
    }
}
