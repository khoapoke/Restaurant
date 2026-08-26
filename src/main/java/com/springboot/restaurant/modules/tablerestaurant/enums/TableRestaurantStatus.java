package com.springboot.restaurant.modules.tablerestaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TableRestaurantStatus {

    TABLE_RESTAURANT_BOOKED("Đã đặt"),
    TABLE_RESTAURANT_EMPTY("Đang trống")

    ;

    private final String description;

}
