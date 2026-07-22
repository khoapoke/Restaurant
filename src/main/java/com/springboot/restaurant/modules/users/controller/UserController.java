package com.springboot.restaurant.modules.users.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.restaurant.modules.users.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserUpdateResponse;
import com.springboot.restaurant.modules.users.dto.response.UserCreationResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;
import com.springboot.restaurant.modules.users.dto.response.UserDeleteResponse;
import com.springboot.restaurant.modules.users.service.interfaces.UserServiceInterface;
import com.springboot.restaurant.shared.ApiResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserServiceInterface userService;

    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

  

    @GetMapping()
    public ResponseEntity<ApiResponse<List<UserResponse>>> getUsers() {

        List<UserResponse> listUser = userService.getList();
       
        return ResponseEntity.ok(ApiResponse.success(2002,"get list user success", listUser));
        

    }

    @PostMapping()
    // thêm anotaion @valid để biết có xài validation trong controller
    public ResponseEntity<ApiResponse<UserCreationResponse>> postUser(@RequestBody @Valid UserCreateRequest entity) {

        UserCreationResponse newuser = userService.createUser(entity);
        
    
        return ResponseEntity.ok(ApiResponse.success(2001,"created account success", newuser));
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> getUser(@PathVariable("userId") Long id) {

        UserResponse user = userService.getUser(id);

        return ResponseEntity.ok(ApiResponse.success(2000, "find user success", user));

    }
  
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserUpdateResponse>> putUser(@PathVariable("userId") Long id,
        @RequestBody UserUpdateRequest request) {
        UserUpdateResponse user = userService.updateUser(id, request);
        
        return ResponseEntity.ok(ApiResponse.success(3000, "update user success", user));
        
        
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserDeleteResponse>> deleteUser(@PathVariable("userId") Long id) {
        
        UserDeleteResponse user = userService.deleteUser(id);
        
        return ResponseEntity.ok(ApiResponse.success(2000, "delete user success", user));
        
        
    }

}
