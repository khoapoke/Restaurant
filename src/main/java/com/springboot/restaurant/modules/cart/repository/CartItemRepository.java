package com.springboot.restaurant.modules.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restaurant.modules.cart.entity.CartDetail;
import com.springboot.restaurant.modules.cart.entity.CartDetailId;

public interface CartItemRepository extends JpaRepository<CartDetail, CartDetailId>
{
    
}
