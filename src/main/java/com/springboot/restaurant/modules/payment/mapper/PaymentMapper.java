package com.springboot.restaurant.modules.payment.mapper;

import org.springframework.stereotype.Component;

import com.springboot.restaurant.modules.payment.dto.request.PaymentCreateRequest;
import com.springboot.restaurant.modules.payment.dto.response.PaymentDetailResponse;
import com.springboot.restaurant.modules.payment.dto.response.PaymentResponse;
import com.springboot.restaurant.modules.payment.entity.Payment;


@Component
public class PaymentMapper {

    public Payment toPaymentEntity(PaymentCreateRequest request) {

        Payment payment = new Payment();
        
       
        payment.setTrangThai(request.getTrangThai());
        payment.setPhuongThuc(request.getPhuongThuc());

        return payment;
    }

    public PaymentResponse toPaymentResponse(Payment payment) {

        PaymentResponse response = new PaymentResponse();

        response.setMaDonhang(payment.getDonHang().getMaDonHang());
        response.setMaThanhToan(payment.getMaThanhToan());
        response.setPhuongThuc(payment.getPhuongThuc());
        response.setTrangThai(payment.getTrangThai());
        response.setSoTien(payment.getSoTien());

        return response;

    }

    public PaymentDetailResponse toPaymentDetailResponse(Payment payment) {

        PaymentDetailResponse response = new PaymentDetailResponse();

        response.setMaDonhang(payment.getDonHang().getMaDonHang());
        response.setMaKhachHang(payment.getDonHang().getTaiKhoan().getMaTaiKhoan());
        response.setTenKhachHang(payment.getDonHang().getTaiKhoan().getTenDangNhap());
        response.setMaThanhToan(payment.getMaThanhToan());
        response.setPhuongThuc(payment.getPhuongThuc());
        response.setTrangThai(payment.getTrangThai());
        response.setSoTien(payment.getSoTien());

        return response;

    }

}
