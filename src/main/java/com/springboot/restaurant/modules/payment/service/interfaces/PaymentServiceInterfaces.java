package com.springboot.restaurant.modules.payment.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.payment.dto.request.PaymentCreateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentMethodUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentStatusUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.response.PaymentDetailResponse;
import com.springboot.restaurant.modules.payment.dto.response.PaymentResponse;
import com.springboot.restaurant.modules.payment.entity.Payment;

public interface PaymentServiceInterfaces {
    
    // utils

    Payment findByMaThanhToan(Long maThanhToan);


    //CRUD
    
    List<PaymentResponse> getList();

    void updatePaymentStatus(PaymentStatusUpdateRequest request,Long id);

    void updatePaymentMethod(PaymentMethodUpdateRequest request, Long id);
    
    void updatePayment(Long id, PaymentUpdateRequest request);

    PaymentDetailResponse getPayment(Long id);

    PaymentResponse createPayemnt(PaymentCreateRequest request);
    
}
