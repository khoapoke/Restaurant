package com.springboot.restaurant.modules.cart.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.modules.cart.dto.request.CartItemCreateRequest;
import com.springboot.restaurant.modules.cart.dto.request.CartItemUpdateRequest;
import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;
import com.springboot.restaurant.modules.cart.service.interfaces.CartItemServiceInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CartItemService implements CartItemServiceInterface {

    private final CartService cartService;

    @Override
    public CartItemResponse addCartItem(CartItemCreateRequest request, Long maGioHang) {
        return cartService.addCartItem(request, maGioHang);
    }

    @Override
    public CartItemResponse updateCartItem(
            CartItemUpdateRequest request, Long maGioHang, Long maMonAn) {
        return cartService.updateCartItem(request, maGioHang, maMonAn);
    }

    @Override
    public void removeCartItem(Long maGiohang, Long maMonAn) {
        cartService.removeCartItem(maGiohang, maMonAn);
    }
}
