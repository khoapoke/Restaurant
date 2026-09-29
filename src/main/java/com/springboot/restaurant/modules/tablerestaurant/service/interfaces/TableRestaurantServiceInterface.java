package com.springboot.restaurant.modules.tablerestaurant.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.tablerestaurant.dto.request.TableRestaurantCreateRequest;
import com.springboot.restaurant.modules.tablerestaurant.dto.request.TableRestaurantUpdateRequest;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantDetailResponse;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantResponse;
import com.springboot.restaurant.modules.tablerestaurant.entity.TableRestaurant;

public interface TableRestaurantServiceInterface {

    // util

    TableRestaurant findByMaBan(Long maBan);

    // CRUD
    List<TableRestaurantResponse> getTableRestaurants();

    TableRestaurantDetailResponse getTableRestaurantDetail(Long maBan);

    TableRestaurantResponse createTableRestaurant(TableRestaurantCreateRequest request);

    TableRestaurantResponse updateTableRestaurant(Long maBan, TableRestaurantUpdateRequest request);

    void removeTableRestaurant(Long maBan);

}
