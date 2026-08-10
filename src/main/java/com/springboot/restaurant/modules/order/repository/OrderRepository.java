package com.springboot.restaurant.modules.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restaurant.modules.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
