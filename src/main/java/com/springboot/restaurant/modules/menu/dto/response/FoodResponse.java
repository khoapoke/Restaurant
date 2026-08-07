package com.springboot.restaurant.modules.menu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponse {

    private Long maMonAn;
    private String tenMonAn;
    private Double giaTien;
    private String moTa;
    private String hinhAnh;

}
