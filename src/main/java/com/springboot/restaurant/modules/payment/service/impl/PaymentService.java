package com.springboot.restaurant.modules.payment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;
import com.springboot.restaurant.modules.order.service.impl.OrderService;
import com.springboot.restaurant.modules.payment.dto.request.PaymentCreateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentMethodUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentStatusUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.response.PaymentDetailResponse;
import com.springboot.restaurant.modules.payment.dto.response.PaymentResponse;
import com.springboot.restaurant.modules.payment.entity.Payment;
import com.springboot.restaurant.modules.payment.mapper.PaymentMapper;
import com.springboot.restaurant.modules.payment.repository.PaymentRepository;
import com.springboot.restaurant.modules.payment.service.interfaces.PaymentServiceInterfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class PaymentService implements PaymentServiceInterfaces {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final OrderService orderService;

    @Override
    public List<PaymentResponse> getList() {

        List<PaymentResponse> listResponses = paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toPaymentResponse)
                .toList();

        return listResponses;

    }

    @Override
    @Transactional
    public void updatePaymentStatus(PaymentStatusUpdateRequest request, Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_NOT_CREATED));

        payment.setTrangThai(request.getTrangThai());
    }

    @Override
    @Transactional
    public void updatePaymentMethod(PaymentMethodUpdateRequest request, Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_NOT_CREATED));

        payment.setPhuongThuc(request.getPhuongThuc());
    }

    @Override
    public PaymentDetailResponse getPayment(Long id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_NOT_CREATED));

        PaymentDetailResponse response = paymentMapper.toPaymentDetailResponse(payment);

        return response;
    }

    @Override
    @Transactional
    public PaymentResponse createPayemnt(PaymentCreateRequest request) {

        if (paymentRepository.existByMaDonHang(request.getMaDonHang())) {
            throw new AppException(ErrorCode.ORDER_HAS_PAID);
        }

        Payment payment = new Payment();
        // System.out.println(request.getMaDonhang());
        payment.setDonHang(orderService.findOrderById(request.getMaDonHang()));
        payment.setSoTien(payment.calculateTotalPayment());
        paymentRepository.save(payment);

        PaymentResponse response = paymentMapper.toPaymentResponse(payment);
        return response;
    }

}
