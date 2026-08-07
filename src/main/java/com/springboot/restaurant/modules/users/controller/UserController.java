package com.springboot.restaurant.modules.users.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.users.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserDetailResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;
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

    @GetMapping
    // method 1: use status in response and body
    public ResponseEntity<ApiResponse<List<UserResponse>>> getUsers() {

        List<UserResponse> listUser = userService.getList();

        return ResponseEntity.status(200).body(ApiResponse.success(200, "Get list user success", listUser));

    }

    @PostMapping
    // method 2: use anotation status code
    @ResponseStatus(HttpStatus.CREATED)
    // thêm anotaion @valid để biết có xài validation trong controller
    public ApiResponse<UserResponse> postUser(@RequestBody @Valid UserCreateRequest entity) {

        UserResponse newuser = userService.createUser(entity);

        return ApiResponse.success(201, "created account success", newuser);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserDetailResponse> getUser(@PathVariable("userId") Long id) {

        UserDetailResponse user = userService.getUser(id);

        return ApiResponse.success(200, "find user success", user);

    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserResponse> putUser(@PathVariable("userId") Long id,
            @RequestBody @Valid UserUpdateRequest request) {
        UserResponse user = userService.updateUser(id, request);

        return ApiResponse.success(201, "update user success", user);

    }

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserResponse> patchUser(@PathVariable("userId") Long id,
            @RequestBody UserUpdateRequest request) {
        UserResponse user = userService.updateUser(id, request);

        return ApiResponse.success(201, "update field success", user);

    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<UserResponse> deleteUser(@PathVariable("userId") Long id) {

        UserResponse user = userService.deleteUser(id);

        return ApiResponse.success(2000, "delete user success", user);

    }

}
