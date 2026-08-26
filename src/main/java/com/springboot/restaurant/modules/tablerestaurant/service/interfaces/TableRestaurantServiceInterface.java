package com.springboot.restaurant.modules.tablerestaurant.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantDetailResponse;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantResponse;

public interface TableRestaurantServiceInterface {

    List<TableRestaurantResponse> getTableRestaurants();

    TableRestaurantDetailResponse getTableRestaurantDetail(Long maBan);

}
