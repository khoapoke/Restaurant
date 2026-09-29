package com.springboot.restaurant.modules.user.service.interfaces;

import java.util.List;

import com.springboot.restaurant.modules.user.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.user.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.user.dto.response.UserDetailResponse;
import com.springboot.restaurant.modules.user.dto.response.UserResponse;

public interface UserServiceInterface {

    List<UserResponse> getList();

    UserResponse createUser(UserCreateRequest request);
    
    UserDetailResponse getUser(Long id);
    
    UserResponse updateUser(Long id,UserUpdateRequest request);
    
    UserResponse deleteUser(Long id);
}
