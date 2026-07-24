package com.springboot.restaurant.modules.menu.service.impl;

import com.springboot.restaurant.modules.menu.repository.FoodRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.modules.menu.dto.response.FoodResponse;
import com.springboot.restaurant.modules.menu.mapper.FoodMapper;
import com.springboot.restaurant.modules.menu.service.interfaces.FoodServiceInterface;


@Service
public class FoodService implements FoodServiceInterface {
    
    private final FoodRepository foodRepository;

    FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<FoodResponse> getList() {
        
        return foodRepository.findAll().stream().map(FoodMapper::toFoodResponse).toList();
        
        
    }
    
}
