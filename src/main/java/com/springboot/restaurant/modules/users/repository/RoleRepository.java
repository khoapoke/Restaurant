package com.springboot.restaurant.modules.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.restaurant.modules.users.entity.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    
    boolean existsByTenVaiTro(String tenVaiTro);
    
    boolean existsByTenVaiTroAndMaVaiTroNot(String tenVaiTro,Long maVaiTro);
    
}
