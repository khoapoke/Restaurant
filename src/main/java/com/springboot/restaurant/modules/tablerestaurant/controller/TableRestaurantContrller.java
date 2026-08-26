package com.springboot.restaurant.modules.tablerestaurant.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantDetailResponse;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantResponse;
import com.springboot.restaurant.modules.tablerestaurant.service.interfaces.TableRestaurantServiceInterface;
import com.springboot.restaurant.shared.ApiResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/table-restaurants")
@AllArgsConstructor
public class TableRestaurantContrller {

    private final TableRestaurantServiceInterface tableRestaurantService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<TableRestaurantResponse>> getTableRestaurants() {

        List<TableRestaurantResponse> responses = tableRestaurantService.getTableRestaurants();
        return ApiResponse.success(200, "get list table restaurant success", responses);

    }

    @GetMapping("/{tableRestaurantId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<TableRestaurantDetailResponse> getTableRestaurantDetail(
            @PathVariable("tableRestaurantId") Long maBan) {

        TableRestaurantDetailResponse response = tableRestaurantService.getTableRestaurantDetail(maBan);

        return ApiResponse.success(200, "get detail table restaurant success", response);

    }

}
