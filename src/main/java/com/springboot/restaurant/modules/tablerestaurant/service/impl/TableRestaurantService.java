package com.springboot.restaurant.modules.tablerestaurant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantDetailResponse;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantResponse;
import com.springboot.restaurant.modules.tablerestaurant.entity.TableRestaurant;
import com.springboot.restaurant.modules.tablerestaurant.mapper.TableRestaurantMapper;
import com.springboot.restaurant.modules.tablerestaurant.repository.TableRestaurantRepository;
import com.springboot.restaurant.modules.tablerestaurant.service.interfaces.TableRestaurantServiceInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class TableRestaurantService implements TableRestaurantServiceInterface {
    private final TableRestaurantRepository tableRestaurantRepository;
    private final TableRestaurantMapper tableRestaurantMapper;

    @Override
    public List<TableRestaurantResponse> getTableRestaurants() {

        return tableRestaurantRepository.findAll()
                .stream()
                .map(tableRestaurantMapper::toTableRestaurantResponse)
                .toList();

    }

    @Override
    public TableRestaurantDetailResponse getTableRestaurantDetail(Long maBan) {

        TableRestaurant tableRestaurant = tableRestaurantRepository.findById(maBan)
                .orElseThrow(() -> new AppException(ErrorCode.TABLE_NOT_FOUND));

        return tableRestaurantMapper.toTableRestaurantDetailResponse(tableRestaurant);

    }

}
