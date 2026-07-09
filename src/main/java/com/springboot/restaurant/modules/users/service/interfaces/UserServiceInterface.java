package com.springboot.restaurant.modules.users.service.interfaces;

import com.springboot.restaurant.modules.users.dto.request.UserCreationRequest;
import com.springboot.restaurant.modules.users.dto.response.UserCreationResponse;

import com.springboot.restaurant.modules.users.dto.response.UsersResponse;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

public interface UserServiceInterface {

    List<UsersResponse> getList();

    UserCreationResponse createUser(@RequestBody UserCreationRequest request);
    
    UsersResponse getUser(Long id);
}
