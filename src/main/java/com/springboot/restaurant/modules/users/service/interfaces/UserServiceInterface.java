package com.springboot.restaurant.modules.users.service.interfaces;

import com.springboot.restaurant.modules.users.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserCreationResponse;
import com.springboot.restaurant.modules.users.dto.response.UserDeleteResponse;
import com.springboot.restaurant.modules.users.dto.response.UserUpdateResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

public interface UserServiceInterface {

    List<UserResponse> getList();

    UserCreationResponse createUser(@RequestBody UserCreateRequest request);
    
    UserResponse getUser(Long id);
    
    UserUpdateResponse updateUser(Long id, @RequestBody UserUpdateRequest request);
    
    UserDeleteResponse deleteUser(Long id);
}
