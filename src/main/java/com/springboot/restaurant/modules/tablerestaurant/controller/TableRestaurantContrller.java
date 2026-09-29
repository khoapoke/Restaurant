package com.springboot.restaurant.modules.tablerestaurant.controller;

import java.util.List;

import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.tablerestaurant.dto.request.TableRestaurantCreateRequest;
import com.springboot.restaurant.modules.tablerestaurant.dto.request.TableRestaurantUpdateRequest;
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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<TableRestaurantResponse> postTableRestaurant(@RequestBody TableRestaurantCreateRequest request) {

        TableRestaurantResponse response = tableRestaurantService.createTableRestaurant(request);

        return ApiResponse.success(201, "createe table success", response);

    }

    @PutMapping("/{tableRestaurantId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<TableRestaurantResponse> putTableRestaurant(@PathVariable("tableRestaurantId") Long maBan,
            @RequestBody TableRestaurantUpdateRequest request) {

        TableRestaurantResponse response = tableRestaurantService.updateTableRestaurant(maBan, request);
        return ApiResponse.success(200, "update success", response);
    }

    @DeleteMapping("/{tableRestaurantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deleteTableRestaurant(@PathVariable("tableRestaurantId") Long maBan) {

        tableRestaurantService.removeTableRestaurant(maBan);

        return ApiResponse.success(204, "remove table success", null);
    }
}
