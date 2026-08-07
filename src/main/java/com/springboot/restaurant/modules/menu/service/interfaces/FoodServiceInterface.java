package com.springboot.restaurant.modules.menu.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.menu.dto.request.FoodCreateRequest;
import com.springboot.restaurant.modules.menu.dto.request.FoodUpdateRequest;
import com.springboot.restaurant.modules.menu.dto.response.FoodDetailResponse;
import com.springboot.restaurant.modules.menu.dto.response.FoodResponse;


public interface FoodServiceInterface {

    List<FoodResponse> getList();

    FoodDetailResponse getFood(Long id);

    FoodResponse createFood(FoodCreateRequest request);

    FoodResponse updateFood(Long id, FoodUpdateRequest request);

    FoodResponse deleteFood(Long id);

}
