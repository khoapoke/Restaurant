package com.springboot.restaurant.modules.user.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.user.dto.request.RoleCreateRequest;
import com.springboot.restaurant.modules.user.dto.request.RoleUpdateRequest;
import com.springboot.restaurant.modules.user.dto.response.RoleResponse;



public interface RoleServiceInterface {

    public List<RoleResponse> getList();
    
    public RoleResponse createdRole(RoleCreateRequest request);
    
    public RoleResponse getRole(Long id);
    
    public RoleResponse updateRole(Long id,RoleUpdateRequest request );
    
    public RoleResponse deleteRole(Long id);
}
