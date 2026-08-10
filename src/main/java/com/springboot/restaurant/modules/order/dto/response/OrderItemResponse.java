package com.springboot.restaurant.modules.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {
    private Long maMonAn;
    private String tenMonAn;
    private Integer soLuong;
    private Double donGia;

}
