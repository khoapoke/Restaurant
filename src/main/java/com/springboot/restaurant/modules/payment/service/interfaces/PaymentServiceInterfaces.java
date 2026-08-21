package com.springboot.restaurant.modules.payment.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.payment.dto.request.PaymentCreateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentMethodUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentStatusUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.response.PaymentDetailResponse;
import com.springboot.restaurant.modules.payment.dto.response.PaymentResponse;

public interface PaymentServiceInterfaces {
    List<PaymentResponse> getList();

    void updatePaymentStatus(PaymentStatusUpdateRequest request,Long id);

    void updatePaymentMethod(PaymentMethodUpdateRequest request, Long id);
    
    PaymentDetailResponse getPayment(Long id);

    PaymentResponse createPayemnt(PaymentCreateRequest request);
    
}
