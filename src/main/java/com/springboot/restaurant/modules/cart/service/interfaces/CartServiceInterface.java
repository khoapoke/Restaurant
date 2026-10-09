package com.springboot.restaurant.modules.cart.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.cart.dto.request.CartCreateRequest;
import com.springboot.restaurant.modules.cart.dto.request.CartItemCreateRequest;
import com.springboot.restaurant.modules.cart.dto.request.CartItemUpdateRequest;
import com.springboot.restaurant.modules.cart.dto.response.CartDetailResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartResponse;
import com.springboot.restaurant.modules.cart.entity.Cart;

public interface CartServiceInterface {

    Cart findCartById(Long maGioHang);

    List<CartResponse> getCarts();

    CartDetailResponse getCart(Long maGioHang);

    CartItemResponse addCartItem(CartItemCreateRequest request, Long maGioHang);

    CartItemResponse updateCartItem(CartItemUpdateRequest request, Long maGioHang, Long maMonAn);

    void removeCartItem(Long maGiohang, Long maMonAn);

    CartResponse createCart(CartCreateRequest request);

    void removeCart(Long maGiohang);
}
