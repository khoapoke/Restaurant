package com.springboot.restaurant.modules.payment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.payment.dto.request.PaymentCreateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentMethodUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.request.PaymentStatusUpdateRequest;
import com.springboot.restaurant.modules.payment.dto.response.PaymentDetailResponse;
import com.springboot.restaurant.modules.payment.dto.response.PaymentResponse;
import com.springboot.restaurant.modules.payment.service.interfaces.PaymentServiceInterfaces;
import com.springboot.restaurant.shared.ApiResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentServiceInterfaces paymentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<PaymentResponse>> getPayments() {

        return ApiResponse.success(200, "get history payment sucess ", paymentService.getList());

    }

    @GetMapping("/{paymentId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PaymentDetailResponse> getPayment(@PathVariable("paymentId") Long id) {

        return ApiResponse.success(200, "get payment detail success", paymentService.getPayment(id));
    }

    @PatchMapping("/{paymentId}/change-status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> putStatusPayment(@PathVariable("paymentId") Long id,
            @RequestBody PaymentStatusUpdateRequest request) {

        paymentService.updatePaymentStatus(request, id);

        return ApiResponse.success(204, "update status payment success", null);

    }

    @PatchMapping("/{paymentId}/change-method")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> putMethodPayment(@PathVariable("paymentId") Long id,
            @RequestBody PaymentMethodUpdateRequest request) {

        paymentService.updatePaymentMethod(request, id);

        return ApiResponse.success(204, "update method payment success", null);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PaymentResponse> postPayment(@RequestBody PaymentCreateRequest request) {

        return ApiResponse.success(201, "create payment success", paymentService.createPayemnt(request));
    }

}
