package com.springboot.restaurant.modules.tablerestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restaurant.modules.tablerestaurant.entity.TableRestaurant;

public interface TableRestaurantRepository extends JpaRepository<TableRestaurant, Long> {

}
