package com.springboot.restaurant.modules.cart.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.cart.dto.request.CartItemCreateRequest;
import com.springboot.restaurant.modules.cart.dto.response.CartDetailResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartResponse;

public interface CartServiceInterface {

    
    List<CartResponse> getCarts();
    
    CartDetailResponse getCart(Long maGioHang);

    CartItemResponse addCartItem(CartItemCreateRequest request,Long maGioHang);
    
}
