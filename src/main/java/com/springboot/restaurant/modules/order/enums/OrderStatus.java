package com.springboot.restaurant.modules.order.enums;

public enum OrderStatus {
    
    // not yet needed for use
    PENDING("Chờ xử lý"),
    PROCESSING("Đang xử lý"),
    SHPPING("Đang giao hàng"),
    SHIPPED("Đã giao giao hàng"),
    CANCELED("Đã hủy");
    
    
    private final String description;

    private OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    
    
}
