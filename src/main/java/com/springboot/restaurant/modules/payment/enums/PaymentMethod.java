package com.springboot.restaurant.modules.payment.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

@AllArgsConstructor
public enum PaymentMethod {
    PAY_WITH_CASH("Thanh toán bằng tiền mặt"),
    PAY_WITH_CARD("Thanh toán bằng thẻ ");

    private final String description;

}
