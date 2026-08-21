package com.springboot.restaurant.modules.payment.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentSatus {

    UNPAID("Chưa thanh toán"),
    PAID("Đã thanh toán"),
    CANCELLED_PAY("Đã hủy thanh toán")

    ;

    private final String description;
}
