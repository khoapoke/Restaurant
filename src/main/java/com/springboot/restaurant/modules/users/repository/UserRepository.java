package com.springboot.restaurant.modules.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.springboot.restaurant.modules.users.entity.Account;

// mặc dù các phiên bản gần đây có thể hiểu, nhưng thêm vào để ghi nhớ
@Repository

public interface UserRepository extends JpaRepository<Account, Long> {
    
    boolean existsByEmail(String email);

    boolean existsByTenDangNhap(String tenDangNhap);
    
    
    
}
