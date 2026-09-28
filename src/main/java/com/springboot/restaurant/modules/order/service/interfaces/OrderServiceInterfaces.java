package com.springboot.restaurant.modules.order.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.order.dto.request.OrderCreateRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderItemAddRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderItemUpdateRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderUpdateRequest;
import com.springboot.restaurant.modules.order.dto.response.OrderDetailResponse;
import com.springboot.restaurant.modules.order.dto.response.OrderItemResponse;
import com.springboot.restaurant.modules.order.dto.response.OrderResponse;
import com.springboot.restaurant.modules.order.entity.Order;
import com.springboot.restaurant.modules.order.entity.OrderDetail;

public interface OrderServiceInterfaces {

    // utils
    boolean existsByMaDonHang(Long maDonHang);

    // Order
    List<OrderResponse> getOrders();

    OrderResponse createOrder(OrderCreateRequest request);

    OrderResponse updateStatusOrder(OrderUpdateRequest request, Long maDonHang);

    OrderDetailResponse getOrderDetail(Long id);

    // Order items
    OrderItemResponse addOrderItem(OrderItemAddRequest request, Long maDonHang);

    void updateQuantityOrderItem(OrderItemUpdateRequest request, Long maDonHang, Long maMonAn);

    OrderItemResponse removeOrderItem(Long maDonHang, Long maMonAn);

    OrderDetail findOrderItemByOrderIdAndFoodId(Long maDonHang, Long maMonAn);

    Order findOrderById(Long maDonHang);
}
