package com.springboot.restaurant.modules.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restaurant.modules.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{
    
}
