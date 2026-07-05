package com.springboot.restaurant.modules.users.services.interfaces;

import com.springboot.restaurant.modules.users.dtos.request.UserCreationRequest;
import com.springboot.restaurant.modules.users.dtos.response.UserResponse;
import com.springboot.restaurant.modules.users.entities.Account;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

public interface UserServiceInterface {

    List<UserResponse> getList();

    Account createdAt(@RequestBody UserCreationRequest request);

}
