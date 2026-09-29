package com.springboot.restaurant.modules.tablerestaurant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;
import com.springboot.restaurant.modules.tablerestaurant.dto.request.TableRestaurantCreateRequest;
import com.springboot.restaurant.modules.tablerestaurant.dto.request.TableRestaurantUpdateRequest;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantDetailResponse;
import com.springboot.restaurant.modules.tablerestaurant.dto.response.TableRestaurantResponse;
import com.springboot.restaurant.modules.tablerestaurant.entity.TableRestaurant;
import com.springboot.restaurant.modules.tablerestaurant.mapper.TableRestaurantMapper;
import com.springboot.restaurant.modules.tablerestaurant.repository.TableRestaurantRepository;
import com.springboot.restaurant.modules.tablerestaurant.service.interfaces.TableRestaurantServiceInterface;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class TableRestaurantService implements TableRestaurantServiceInterface {

    private final TableRestaurantRepository tableRestaurantRepository;
    private final TableRestaurantMapper tableRestaurantMapper;

    // util

    @Override
    public TableRestaurant findByMaBan(Long maBan) {

        return tableRestaurantRepository.findById(maBan).orElseThrow(() -> new AppException(ErrorCode.TABLE_NOT_FOUND));

    }

    // lấy danh sách bàn ăn
    @Override
    public List<TableRestaurantResponse> getTableRestaurants() {

        return tableRestaurantRepository.findAll()
                .stream()
                .map(tableRestaurantMapper::toTableRestaurantResponse)
                .toList();

    }

    // chi tiết của bàn ăn
    @Override
    public TableRestaurantDetailResponse getTableRestaurantDetail(Long maBan) {

        TableRestaurant tableRestaurant = findByMaBan(maBan);

        return tableRestaurantMapper.toTableRestaurantDetailResponse(tableRestaurant);

    }

    // thêm mới bàn ăn
    @Override
    @Transactional
    public TableRestaurantResponse createTableRestaurant(TableRestaurantCreateRequest request) {

        TableRestaurant tableRestaurant = tableRestaurantMapper.toEntityTableRestaurant(request);

        TableRestaurant saveTableRestaurant = tableRestaurantRepository.save(tableRestaurant);

        return tableRestaurantMapper.toTableRestaurantResponse(saveTableRestaurant);

    }

    // cập nhật bàn ăn
    @Override
    @Transactional
    public TableRestaurantResponse updateTableRestaurant(Long maBan, TableRestaurantUpdateRequest request) {

        TableRestaurant existingTableRestaurant = findByMaBan(maBan);

        tableRestaurantMapper.updateEntityFromRequest(request, existingTableRestaurant);

        return tableRestaurantMapper.toTableRestaurantResponse(existingTableRestaurant);

    }

    // xóa bàn ăn
    @Override
    public void removeTableRestaurant(Long maBan) {

        TableRestaurant existingTableRestaurant = findByMaBan(maBan);

        tableRestaurantRepository.delete(existingTableRestaurant);

    }

}
