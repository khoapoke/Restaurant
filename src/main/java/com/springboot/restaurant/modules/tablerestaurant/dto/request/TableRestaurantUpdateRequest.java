package com.springboot.restaurant.modules.tablerestaurant.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
public class TableRestaurantUpdateRequest {
    
    private String tenBan;
    private Integer sucChua;
    private String trangThai;
    private String viTri;
}
