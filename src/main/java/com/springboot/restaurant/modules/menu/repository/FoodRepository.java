package com.springboot.restaurant.modules.menu.repository;
import com.springboot.restaurant.modules.menu.entity.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {

    

    
}
