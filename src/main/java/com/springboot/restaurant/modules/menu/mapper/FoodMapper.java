package com.springboot.restaurant.modules.menu.mapper;

import com.springboot.restaurant.modules.menu.dto.response.FoodResponse;
import com.springboot.restaurant.modules.menu.entity.Food;

public class FoodMapper {
    public static Food toEnity(FoodResponse response) {

        Food food = new Food();

        food.setTenMonAn(response.getTenMonAn());
        food.setGiaTien(response.getGiaTien());
        food.setMoTa(response.getMoTa());
        food.setHinhAnh(response.getHinhAnh());

        return food;

    }
    
    public static FoodResponse toFoodResponse(Food food) {
        
        FoodResponse response = new FoodResponse();
        
        response.setTenMonAn(food.getTenMonAn());
        response.setGiaTien(food.getGiaTien());
        response.setMoTa(food.getMoTa());
        response.setHinhAnh(food.getHinhAnh());
        
        return response;
        
        
        
        
        
    }
    
}
