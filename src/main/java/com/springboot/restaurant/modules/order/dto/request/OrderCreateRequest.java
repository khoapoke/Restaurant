package com.springboot.restaurant.modules.order.dto.request;

import java.time.LocalDateTime;

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
public class OrderCreateRequest {

    @NotNull(message = "maTaiKhoan cannot be null")
    private Long maTaiKhoan;

    private LocalDateTime ngayDatHang;

    @NotBlank(message = "diaChiGiaoHang cannot be empty")
    private String diaChiGiaoHang;

    @NotBlank(message = "trangThai cannot be empty")
    private String trangThai;

}
