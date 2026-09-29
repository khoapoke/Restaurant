package com.springboot.restaurant.modules.cart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;
import com.springboot.restaurant.modules.cart.dto.request.CartItemCreateRequest;
import com.springboot.restaurant.modules.cart.dto.response.CartDetailResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartResponse;
import com.springboot.restaurant.modules.cart.entity.Cart;
import com.springboot.restaurant.modules.cart.entity.CartDetail;
import com.springboot.restaurant.modules.cart.mapper.CartMapper;
import com.springboot.restaurant.modules.cart.repository.CartRepository;
import com.springboot.restaurant.modules.cart.service.interfaces.CartServiceInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@AllArgsConstructor
@Getter
public class CartService implements CartServiceInterface {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    public CartDetailResponse getCart(Long maGioHang) {

        Cart cart = cartRepository.findById(maGioHang).orElseThrow(() -> new AppException(ErrorCode.CART_NOT_FOUND));

        CartDetailResponse response = cartMapper.toCartDetailResponse(cart);

        return response;

    }

    @Override
    public List<CartResponse> getCarts() {

        return cartRepository.findAll()
                .stream()
                .map(cartMapper::toCartResponse)
                .toList();

    }

    @Override
    public CartItemResponse addCartItem(CartItemCreateRequest request, Long maGioHang) {

        Cart cart = cartRepository.findById(maGioHang).orElseThrow(() -> new AppException(ErrorCode.CART_NOT_FOUND));

        CartDetail cartDetail = cartMapper.toEntityCartDetail(request);

        cart.addCartitem(cartDetail);

        return cartMapper.toCartItemResponse(cartDetail);

    }
}
