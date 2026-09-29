package com.springboot.restaurant.modules.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;
import com.springboot.restaurant.modules.order.dto.request.OrderCreateRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderItemAddRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderItemUpdateRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderUpdateRequest;
import com.springboot.restaurant.modules.order.dto.response.OrderDetailResponse;
import com.springboot.restaurant.modules.order.dto.response.OrderItemResponse;
import com.springboot.restaurant.modules.order.dto.response.OrderResponse;
import com.springboot.restaurant.modules.order.entity.Order;
import com.springboot.restaurant.modules.order.entity.OrderDetail;
import com.springboot.restaurant.modules.order.entity.OrderDetailId;
import com.springboot.restaurant.modules.order.mapper.OrderMapper;
import com.springboot.restaurant.modules.order.repository.OrderDetailRepository;
import com.springboot.restaurant.modules.order.repository.OrderRepository;
import com.springboot.restaurant.modules.order.service.interfaces.OrderServiceInterfaces;
import com.springboot.restaurant.modules.user.entity.Account;
import com.springboot.restaurant.modules.user.repository.UserRepository;
import com.springboot.restaurant.modules.menu.entity.Food;
import com.springboot.restaurant.modules.menu.repository.FoodRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService implements OrderServiceInterfaces {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private final OrderMapper orderMapper;

    @Override
    public boolean existsByMaDonHang(Long maDonHang) {
        if (orderRepository.existsByMaDonHang(maDonHang))
            return true;
        else
            return false;
    }

    @Override
    public List<OrderResponse> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    @Override
    @Transactional
    public OrderResponse createOrder(OrderCreateRequest request) {
        if (request == null)
            return null;

        Account account = userRepository.findById(request.getMaTaiKhoan())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        Order order = orderMapper.toOrderEntity(request);
        order.setTaiKhoan(account);
        order.setTongTien(0.0);

        orderRepository.save(order);

        return orderMapper.toOrderResponse(order);
    }

    @Override
    @Transactional
    public OrderResponse updateStatusOrder(OrderUpdateRequest request, Long maDonHang) {
        Order order = orderRepository.findById(maDonHang)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));

        order.setTrangThai(request.getTrangThai());
        return orderMapper.toOrderResponse(order);
    }

    @Override
    public OrderDetailResponse getOrderDetail(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        return orderMapper.toOrderDetailResponse(order);
    }

    // Order Items
    @Override
    @Transactional
    public OrderItemResponse addOrderItem(OrderItemAddRequest request, Long maDonHang) {
        Order order = orderRepository.findById(maDonHang)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));

        Food food = foodRepository.findById(request.getMaMonAn())
                .orElseThrow(() -> new AppException(ErrorCode.FOOD_NOT_FOUND)); // Assuming FOOD_NOT_FOUND exists or a
                                                                                // generic one

        OrderDetailId orderDetailId = new OrderDetailId(maDonHang, request.getMaMonAn());
        Optional<OrderDetail> existingDetail = orderDetailRepository.findById(orderDetailId);

        OrderDetail orderDetail;
        if (existingDetail.isPresent()) {
            orderDetail = existingDetail.get();
            orderDetail.setSoLuong(orderDetail.getSoLuong() + request.getSoLuong());
        } else {
            orderDetail = orderMapper.toOrderDetailEntity(request);
            orderDetail.setMonAn(food);
            orderDetail.setDonGia(food.getGiaTien());
            order.addOrderDetail(orderDetail);
        }

        order.setTongTien(order.calculateTotalOrderItems());
        return orderMapper.toOrderItemResponse(orderDetail);
    }

    @Override
    public OrderDetail findOrderItemByOrderIdAndFoodId(Long maDonHang, Long maMonAn) {
        OrderDetailId orderDetailId = new OrderDetailId(maDonHang, maMonAn);
        return orderDetailRepository.findById(orderDetailId)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
    }

    @Override
    @Transactional
    public void updateQuantityOrderItem(OrderItemUpdateRequest request, Long maDonHang, Long maMonAn) {
        OrderDetail orderDetail = findOrderItemByOrderIdAndFoodId(maDonHang, maMonAn);
        orderDetail.setSoLuong(request.getSoLuong());

        Order order = orderDetail.getDonHang();
        order.setTongTien(order.calculateTotalOrderItems());
    }

    @Override
    @Transactional
    public OrderItemResponse removeOrderItem(Long maDonHang, Long maMonAn) {
        OrderDetail orderDetail = findOrderItemByOrderIdAndFoodId(maDonHang, maMonAn);
        Order order = orderRepository.findById(maDonHang)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));

        order.removeOrderDetail(orderDetail);
        order.setTongTien(order.calculateTotalOrderItems());

        return orderMapper.toOrderItemResponse(orderDetail);
    }

    @Override
    public Order findOrderById(Long maDonHang) {
        return orderRepository.findById(maDonHang).orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
    }

}
