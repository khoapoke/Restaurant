package com.springboot.restaurant.modules.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restaurant.modules.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    boolean existByMaDonHang(Long maDonHang);
}
