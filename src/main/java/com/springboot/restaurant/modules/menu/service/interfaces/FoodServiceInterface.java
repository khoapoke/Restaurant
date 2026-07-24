package com.springboot.restaurant.modules.menu.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.menu.dto.response.FoodResponse;

public interface FoodServiceInterface {

    List<FoodResponse> getList();

    
}
