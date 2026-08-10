package com.springboot.restaurant.modules.order.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemAddRequest {

    @NotNull(message = "maMonAn cannot be null")
    private Long maMonAn;

    @NotNull(message = "soLuong cannot be null")
    @Min(value = 1, message = "soLuong must be at least 1")
    private Integer soLuong;

}
