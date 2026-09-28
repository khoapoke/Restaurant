package com.springboot.restaurant.modules.order.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.restaurant.modules.order.dto.request.OrderCreateRequest;
import com.springboot.restaurant.modules.order.dto.request.OrderItemAddRequest;
import com.springboot.restaurant.modules.order.dto.response.OrderDetailResponse;
import com.springboot.restaurant.modules.order.dto.response.OrderItemResponse;
import com.springboot.restaurant.modules.order.dto.response.OrderResponse;
import com.springboot.restaurant.modules.order.entity.Order;
import com.springboot.restaurant.modules.order.entity.OrderDetail;

import com.springboot.restaurant.modules.order.entity.OrderDetailId;

@Component
public class OrderMapper {

    public Order toOrderEntity(OrderCreateRequest request) {

        if (request == null)
            return null;

        Order order = new Order();

        order.setNgayDatHang(request.getNgayDatHang());
        order.setDiaChiGiaoHang(request.getDiaChiGiaoHang());
        order.setTrangThai(request.getTrangThai());

        return order;

    }

    public OrderDetail toOrderDetailEntity(OrderItemAddRequest request) {
        if (request == null)
            return null;

        OrderDetail orderDetail = new OrderDetail();
        OrderDetailId orderDetailId = new OrderDetailId();
        
        orderDetailId.setMaMonAn(request.getMaMonAn());
        orderDetail.setOrderDetailId(orderDetailId);
        orderDetail.setSoLuong(request.getSoLuong());

        return orderDetail;
    }

    public OrderResponse toOrderResponse(Order order) {

        if (order == null)
            return null;

        OrderResponse response = new OrderResponse();

        response.setMaDonHang(order.getMaDonHang());
        response.setNgayDatHang(order.getNgayDatHang());
        response.setDiaChiGiaoHang(order.getDiaChiGiaoHang());
        response.setTrangThai(order.getTrangThai());
        response.setTongTien(order.getTongTien());

        return response;

    }

    public OrderDetailResponse toOrderDetailResponse(Order order) {
        if (order == null)
            return null;

        OrderDetailResponse response = new OrderDetailResponse();

        response.setMaDonHang(order.getMaDonHang());

        response.setNgayDatHang(order.getNgayDatHang());
        response.setDiaChiGiaoHang(order.getDiaChiGiaoHang());
        response.setTrangThai(order.getTrangThai());
        response.setTongTien(order.getTongTien());

        if (order.getTaiKhoan() != null) {
            response.setTenKhachHang(order.getTaiKhoan().getNguoiDung().getHoTen());
        }

        if (order.getDanhSachChiTietDonHang() != null) {

            List<OrderItemResponse> orderDetails = order.getDanhSachChiTietDonHang()
                    .stream()
                    .map(this::toOrderItemResponse)
                    .toList();

            response.setDanhSachMonAn(orderDetails);
        }

        return response;

    }

    public OrderItemResponse toOrderItemResponse(OrderDetail orderDetail) {
        if (orderDetail == null)
            return null;

        OrderItemResponse response = new OrderItemResponse();

        response.setDonGia(orderDetail.getDonGia());

        response.setSoLuong(orderDetail.getSoLuong());

        if (orderDetail.getMonAn() != null) {
            response.setMaMonAn(orderDetail.getMonAn().getMaMonAn());
            response.setTenMonAn(orderDetail.getMonAn().getTenMonAn());
        }

        return response;
    }

}
