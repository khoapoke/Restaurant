package com.springboot.restaurant.modules.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.springboot.restaurant.modules.users.entities.Account;

// mặc dù các phiên bản gần đây có thể hiểu, nhưng thêm vào để ghi nhớ
@Repository

public interface UserRepository extends JpaRepository<Account, Long> {

}
