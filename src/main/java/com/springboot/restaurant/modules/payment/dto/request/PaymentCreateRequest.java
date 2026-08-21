package com.springboot.restaurant.modules.payment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreateRequest {

    @NotNull(message = "please chosse at lease 1 order to pay")
    private Long maDonHang;

    @NotBlank(message = "please chosse 1 method to pay")
    private String phuongThuc;

    @NotBlank(message = "please chosse 1 status ")
    private String trangThai;

}
