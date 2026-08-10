package com.springboot.restaurant.modules.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restaurant.modules.order.entity.OrderDetail;
import com.springboot.restaurant.modules.order.entity.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

}
