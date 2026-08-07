package com.springboot.restaurant.modules.menu.mapper;

import org.springframework.stereotype.Component;

import com.springboot.restaurant.modules.menu.dto.request.FoodCreateRequest;
import com.springboot.restaurant.modules.menu.dto.request.FoodUpdateRequest;
import com.springboot.restaurant.modules.menu.dto.response.FoodDetailResponse;
import com.springboot.restaurant.modules.menu.dto.response.FoodResponse;
import com.springboot.restaurant.modules.menu.entity.Food;

@Component

public class FoodMapper {
    public Food toEntity(FoodCreateRequest request) {

        Food food = new Food();
        food.setTenMonAn(request.getTenMonAn());
        food.setGiaTien(request.getGiaTien());
        food.setMoTa(request.getMoTa());
        food.setHinhAnh(request.getHinhAnh());

        return food;
    }

    public FoodResponse toFoodResponse(Food food) {

        if (food == null)
            return null;

        FoodResponse response = new FoodResponse();
        response.setMaMonAn(food.getMaMonAn());
        response.setTenMonAn(food.getTenMonAn());
        response.setGiaTien(food.getGiaTien());
        response.setMoTa(food.getMoTa());
        response.setHinhAnh(food.getHinhAnh());

        return response;

    }

    public FoodDetailResponse toFoodDetailResponse(Food food) {

        FoodDetailResponse response = new FoodDetailResponse();
        response.setMaMonAn(food.getMaMonAn());
        response.setTenMonAn(food.getTenMonAn());
        response.setGiaTien(food.getGiaTien());
        response.setHinhAnh(food.getHinhAnh());
        response.setMoTa(food.getMoTa());

        response.setTenDanhMuc(food.getDanhMuc().getTenDanhMuc());
        response.setMoTaDanhMuc(food.getDanhMuc().getMoTa());

        return response;

    }

    public void updateEntityFromRequest(FoodUpdateRequest request, Food existingFood) {

        existingFood.setTenMonAn(request.getTenMonAn());
        existingFood.setGiaTien(request.getGiaTien());
        existingFood.setMoTa(request.getMoTa());
        existingFood.setHinhAnh(request.getHinhAnh());

    }

}
