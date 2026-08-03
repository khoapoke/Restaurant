package com.springboot.restaurant.modules.users.service.interfaces;

import com.springboot.restaurant.modules.users.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserDetailResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

public interface UserServiceInterface {

    List<UserResponse> getList();

    UserResponse createUser(@RequestBody UserCreateRequest request);
    
    UserDetailResponse getUser(Long id);
    
    UserResponse updateUser(Long id,UserUpdateRequest request);
    
    UserResponse deleteUser(Long id);
}
