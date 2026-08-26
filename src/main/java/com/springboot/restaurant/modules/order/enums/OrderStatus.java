package com.springboot.restaurant.modules.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    // not yet needed for use
    PENDING("Chờ xử lý"),
    PROCESSING("Đang xử lý"),
    SHPPING("Đang giao hàng"),
    SHIPPED("Đã giao giao hàng"),
    CANCELED("Đã hủy");

    private final String description;

}
