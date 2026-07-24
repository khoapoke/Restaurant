package com.springboot.restaurant.modules.menu.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.menu.dto.response.FoodResponse;

import com.springboot.restaurant.modules.menu.service.interfaces.FoodServiceInterface;

import com.springboot.restaurant.shared.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("api/v1/foods")
public class FoodController {
    
    
    private final FoodServiceInterface foodService;
    
    public FoodController(FoodServiceInterface foodService)
    {
            this.foodService=foodService;
            
    }
    
    
    @GetMapping()
    public ResponseEntity<ApiResponse<List<FoodResponse>>> getFoods() {
        
        List<FoodResponse> foods = foodService.getList();
        
        return ResponseEntity.ok(ApiResponse.success(1001, "get list success", foods));
        
    }
    
    
    
}
