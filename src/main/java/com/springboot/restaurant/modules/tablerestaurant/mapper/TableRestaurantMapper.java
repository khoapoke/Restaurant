package com.springboot.restaurant.modules.tablerestaurant.mapper;

import org.springframework.stereotype.Component;

import com.springboot.restaurant.modules.tablerestaurant.dto.request.TableRestaurantCreateRequest;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantDetailResponse;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantResponse;
import com.springboot.restaurant.modules.tablerestaurant.entity.TableReservation;
import com.springboot.restaurant.modules.tablerestaurant.entity.TableRestaurant;

@Component 
public class TableRestaurantMapper {

    public TableRestaurant toEntityTableRestaurant(TableRestaurantCreateRequest request) {

        return null;

    }

    public TableReservation toEntityTableReservation() {
        return null;
    }

    public TableRestaurantResponse toTableRestaurantResponse(TableRestaurant tableRestaurant) {

        TableRestaurantResponse response = new TableRestaurantResponse();

        response.setMaBan(tableRestaurant.getMaBan());
        response.setTenBan(tableRestaurant.getTenBan());
        response.setSucChua(tableRestaurant.getSucChua());
        response.setTrangThai(tableRestaurant.getTrangThai());
        response.setViTri(tableRestaurant.getViTri());

        return response;

    }

    public TableRestaurantDetailResponse toTableRestaurantDetailResponse(TableRestaurant tableRestaurant) {

        TableRestaurantDetailResponse response = new TableRestaurantDetailResponse();

        response.setMaBan(tableRestaurant.getMaBan());
        response.setTenBan(tableRestaurant.getTenBan());
        response.setSucChua(tableRestaurant.getSucChua());
        response.setTrangThai(tableRestaurant.getTrangThai());
        response.setViTri(tableRestaurant.getViTri());

        return response;

    }
    
}
