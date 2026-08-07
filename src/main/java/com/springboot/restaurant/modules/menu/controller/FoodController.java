package com.springboot.restaurant.modules.menu.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.menu.dto.request.FoodCreateRequest;
import com.springboot.restaurant.modules.menu.dto.request.FoodUpdateRequest;
import com.springboot.restaurant.modules.menu.dto.response.FoodDetailResponse;
import com.springboot.restaurant.modules.menu.dto.response.FoodResponse;

import com.springboot.restaurant.modules.menu.service.interfaces.FoodServiceInterface;

import com.springboot.restaurant.shared.ApiResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/foods")
public class FoodController {

    private final FoodServiceInterface foodService;

    public FoodController(FoodServiceInterface foodService) {
        this.foodService = foodService;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<FoodResponse>> getFoods() {

        List<FoodResponse> foods = foodService.getList();

        return ApiResponse.success(200, "get list success", foods);

    }

    @GetMapping("/{foodId}")
    public ApiResponse<FoodDetailResponse> getFood(@PathVariable("foodId") Long id) {

        FoodDetailResponse response = foodService.getFood(id);

        return ApiResponse.success(200, "get detail food success", response);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<FoodResponse> postFood(@RequestBody @Valid FoodCreateRequest request) {

        FoodResponse response = foodService.createFood(request);

        return ApiResponse.success(201, "create food success", response);

    }

    @PutMapping("/{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<FoodResponse> putFood(@RequestBody @Valid FoodUpdateRequest request,
            @PathVariable("foodId") Long id) {

        FoodResponse response = foodService.updateFood(id, request);

        return ApiResponse.success(200, "update sucess", response);

    }

    @PatchMapping("/{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<FoodResponse> patchFood(@RequestBody FoodUpdateRequest request,
            @PathVariable("foodId") Long id) {

        FoodResponse response = foodService.updateFood(id, request);

        return ApiResponse.success(200, "update sucess", response);

    }

    @DeleteMapping("/{foodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<FoodResponse> deleteFood(@PathVariable("foodId") Long id) {
        FoodResponse response = foodService.deleteFood(id);

        return ApiResponse.success(204, "delete success", response);
    }

}
