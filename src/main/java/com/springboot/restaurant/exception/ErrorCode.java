package com.springboot.restaurant.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // ACCOUNT
    USER_NOT_FOUND(404, "User not found in system"),
    EMAIL_EXISTED(409, "Email already exists"),
    INVALID_KEY(409, "Uncategorized error"),
    TENDANGNHAP_EXISTED(409, "User name already exists"),

    // ROLE
    ROLE_EXISTED(409, "role already existed"),
    ROLE_NOT_FOUND(404, "role has not been create"),

    // FOOD
    CATEGORY_NOT_FOUND(404, "category food not exist"),
    FOOD_NOT_FOUND(404, "food not found"),

    // ORDER
    ORDER_NOT_FOUND(404, "order hasn't created yet"),
    ORDER_HAS_PAID(409, "order has been paid"),
    // PAYMENT
    PAYMENT_NOT_CREATED(404, "this payment has not been create "),

    // CART & CARTDETAIL
    CART_NOT_FOUND(404, "cart not found"),

    // TABLE RESERVATION
    TABLE_NOT_FOUND(404, "table not found")

    ;

    private final int code;
    private final String message;
    

}
