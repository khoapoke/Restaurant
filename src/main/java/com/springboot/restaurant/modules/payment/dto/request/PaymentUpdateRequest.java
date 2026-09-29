package com.springboot.restaurant.modules.payment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
public class PaymentUpdateRequest {
    private String phuongThuc;
    private String trangThai;
}
