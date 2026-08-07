package com.springboot.restaurant.modules.menu.service.impl;

import com.springboot.restaurant.modules.menu.repository.FoodCategoryRepository;
import com.springboot.restaurant.modules.menu.repository.FoodRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;
import com.springboot.restaurant.modules.menu.dto.request.FoodCreateRequest;
import com.springboot.restaurant.modules.menu.dto.request.FoodUpdateRequest;
import com.springboot.restaurant.modules.menu.dto.response.FoodDetailResponse;
import com.springboot.restaurant.modules.menu.dto.response.FoodResponse;
import com.springboot.restaurant.modules.menu.entity.Food;
import com.springboot.restaurant.modules.menu.mapper.FoodMapper;
import com.springboot.restaurant.modules.menu.service.interfaces.FoodServiceInterface;

import lombok.AllArgsConstructor;

import com.springboot.restaurant.modules.menu.entity.FoodCategory;

@Service
@AllArgsConstructor
public class FoodService implements FoodServiceInterface {

    private final FoodRepository foodRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final FoodMapper foodMapper;

    @Override
    public List<FoodResponse> getList() {

        List<FoodResponse> foods = foodRepository.findAll().stream().map(foodMapper::toFoodResponse).toList();

        return foods;

    }

    @Override
    public FoodDetailResponse getFood(Long id) {

        Food food = foodRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.FOOD_NOT_FOUND));

        FoodDetailResponse response = foodMapper.toFoodDetailResponse(food);

        return response;
    }

    public FoodResponse createFood(FoodCreateRequest request) {

        Food food = foodMapper.toEntity(request);

        FoodCategory foodCategory = foodCategoryRepository.findById(request.getMaDanhMuc())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));

        food.setDanhMuc(foodCategory);

        Food saveFood = foodRepository.save(food);

        FoodResponse response = foodMapper.toFoodResponse(saveFood);

        return response;

    }

    public FoodResponse updateFood(Long id, FoodUpdateRequest request) {

        Food food = foodRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.FOOD_NOT_FOUND));

        foodMapper.updateEntityFromRequest(request, food);

        // food.getDanhMuc().setMaDanhMuc(request.getMaDanhMuc());

        if (request.getMaDanhMuc() != null) {
            FoodCategory category = foodCategoryRepository.findById(request.getMaDanhMuc())
                    .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));

            food.setDanhMuc(category);
        }

        Food saveFood = foodRepository.save(food);

        FoodResponse response = foodMapper.toFoodResponse(saveFood);

        return response;

    }

    public FoodResponse deleteFood(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.FOOD_NOT_FOUND));

        foodRepository.delete(food);

        FoodResponse response = foodMapper.toFoodResponse(food);

        return response;
    }

}
