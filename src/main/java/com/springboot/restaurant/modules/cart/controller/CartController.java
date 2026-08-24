package com.springboot.restaurant.modules.cart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.cart.dto.request.CartItemCreateRequest;
import com.springboot.restaurant.modules.cart.dto.response.CartDetailResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartItemResponse;
import com.springboot.restaurant.modules.cart.dto.response.CartResponse;
import com.springboot.restaurant.modules.cart.service.interfaces.CartServiceInterface;
import com.springboot.restaurant.shared.ApiResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/carts")
@AllArgsConstructor

public class CartController {

    private final CartServiceInterface cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<CartResponse>> getCarts() {
        List<CartResponse> carts = cartService.getCarts();
        return ApiResponse.success(200, "get list success", carts);

    }

    @GetMapping("/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<CartDetailResponse> getCart(@PathVariable("cartId") Long maGiohang) {

        return ApiResponse.success(
                200,
                "get detail cart success",
                cartService.getCart(maGiohang)

        );

    }

    @PostMapping("/{cartId}//items")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CartItemResponse> addItemInCart(@PathVariable("cartId") Long maGioHang,
            @RequestBody CartItemCreateRequest request) {
                
        CartItemResponse response = cartService.addItem(request, maGioHang);
        return ApiResponse.success(204, "add item success", response);

    }

}
