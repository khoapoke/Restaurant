package com.springboot.restaurant.modules.order.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.order.dto.request.OrderCreateRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderItemAddRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderItemUpdateRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderUpdateRequest;
import com.springboot.restaurant.modules.order.dto.response.OrderDetailResponse;
import com.springboot.restaurant.modules.order.dto.response.OrderItemResponse;
import com.springboot.restaurant.modules.order.dto.response.OrderResponse;
import com.springboot.restaurant.modules.order.service.interfaces.OrderServiceInterfaces;
import com.springboot.restaurant.shared.ApiResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderServiceInterfaces orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<OrderResponse>> getOrders() {
        List<OrderResponse> responses = orderService.getOrders();
        return ApiResponse.success(200, "get list order success", responses);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<OrderResponse> createOrder(@RequestBody @Valid OrderCreateRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return ApiResponse.success(201, "create order success", response);
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<OrderDetailResponse> getOrder(@PathVariable("orderId") Long id) {
        OrderDetailResponse response = orderService.getOrderDetail(id);
        return ApiResponse.success(200, "get order success", response);
    }

    @PutMapping("/{orderId}/status")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<OrderResponse> updateOrderStatus(
            @PathVariable("orderId") Long orderId,
            @RequestBody @Valid OrderUpdateRequest request) {
        OrderResponse response = orderService.updateStatusOrder(request, orderId);
        return ApiResponse.success(200, "update order status success", response);
    }

    // Order Items Endpoints

    @PostMapping("/{orderId}/items")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<OrderItemResponse> addOrderItem(
            @PathVariable("orderId") Long orderId,
            @RequestBody @Valid OrderItemAddRequest request) {
        OrderItemResponse response = orderService.addOrderItem(request, orderId);
        return ApiResponse.success(201, "add item to order success", response);
    }

    @PutMapping("/{orderId}/items/{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> updateOrderItemQuantity(
            @PathVariable("orderId") Long orderId,
            @PathVariable("foodId") Long foodId,
            @RequestBody @Valid OrderItemUpdateRequest request) {
        orderService.updateQuantityOrderItem(request, orderId, foodId);
        return ApiResponse.success(200, "update item quantity success", null);
    }

    @DeleteMapping("/{orderId}/items/{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<OrderItemResponse> removeOrderItem(
            @PathVariable("orderId") Long orderId,
            @PathVariable("foodId") Long foodId) {
        OrderItemResponse response = orderService.removeOrderItem(orderId, foodId);
        return ApiResponse.success(200, "remove item from order success", response);
    }
}
