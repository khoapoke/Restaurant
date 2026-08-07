package com.springboot.restaurant.modules.menu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodUpdateRequest {
    @NotBlank(message = "this field mustn't be empty")
    private String tenMonAn;

    @NotNull(message = "this field mustn't be empty")
    @Positive(message = "price must be greater than 0")
    private Double giaTien;

    @Size(min = 0, max = 255, message = "Description is too long")
    private String moTa;

    @NotBlank(message = "this field mustn't be empty")
    private String hinhAnh;

    @NotNull(message = "this field mustn't be empty")
    private Long maDanhMuc;

}
