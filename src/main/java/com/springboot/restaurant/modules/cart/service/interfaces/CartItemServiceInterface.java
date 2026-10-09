package com.springboot.restaurant.modules.cart.service.interfaces;

import com.springboot.restaurant.modules.cart.dto.request.CartItemCreateRequest;
import com.springboot.restaurant.modules.cart.dto.request.CartItemUpdateRequest;
import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;

public interface CartItemServiceInterface {
        CartItemResponse addCartItem(CartItemCreateRequest request, Long maGioHang);
        CartItemResponse updateCartItem(CartItemUpdateRequest request, Long maGioHang, Long maMonAn);
        void removeCartItem(Long maGiohang, Long maMonAn);
}
