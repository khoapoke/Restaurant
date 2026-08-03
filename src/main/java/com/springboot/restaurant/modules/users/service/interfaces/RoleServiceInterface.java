package com.springboot.restaurant.modules.users.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.users.dto.request.RoleCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.RoleUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.RoleResponse;



public interface RoleServiceInterface {

    public List<RoleResponse> getList();
    
    public RoleResponse createdRole(RoleCreateRequest request);
    
    public RoleResponse getRole(Long id);
    
    public RoleResponse updateRole(Long id,RoleUpdateRequest request );
    
    public RoleResponse deleteRole(Long id);
}
