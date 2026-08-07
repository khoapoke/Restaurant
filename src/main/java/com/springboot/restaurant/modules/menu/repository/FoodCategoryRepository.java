package com.springboot.restaurant.modules.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restaurant.modules.menu.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory,Long>{
    
}
