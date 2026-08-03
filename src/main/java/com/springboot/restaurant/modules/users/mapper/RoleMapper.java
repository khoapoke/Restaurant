package com.springboot.restaurant.modules.users.mapper;


import org.springframework.stereotype.Component;

import com.springboot.restaurant.modules.users.dto.request.RoleCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.RoleUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.RoleResponse;
import com.springboot.restaurant.modules.users.entity.Role;

@Component

public class RoleMapper {

    public  Role toEntity(RoleCreateRequest request){
        Role role = new Role();
        role.setTenVaiTro(request.getTenVaiTro());
        
        return role;
        
    }
    
    
    public  RoleResponse toRoleResponse(Role role) {
        RoleResponse dto = new RoleResponse();
        dto.setMaVaiTro(role.getMaVaiTro());
        dto.setTenVaiTro(role.getTenVaiTro());

        return dto;

    }
    
    
    
    public RoleResponse toRoleCreateResponse(Role role) {
        RoleResponse dto = new RoleResponse();
        dto.setMaVaiTro(role.getMaVaiTro());
        dto.setTenVaiTro(role.getTenVaiTro());

        return dto;
    }
    
    public void updateEntityFromRequest(RoleUpdateRequest request, Role existingRole) {
        existingRole.setTenVaiTro(request.getTenVaiTro());
    }
    
    public RoleResponse toRoleUpdatResponse(RoleUpdateRequest request) {
        RoleResponse response = new RoleResponse();
        response.setTenVaiTro(request.getTenVaiTro());

        return response;

    }
    
    public RoleResponse toRoleDeleteResponse(Role role) {
        RoleResponse response = new RoleResponse();
        response.setMaVaiTro(role.getMaVaiTro());
        
        return response;
    }
    
}
