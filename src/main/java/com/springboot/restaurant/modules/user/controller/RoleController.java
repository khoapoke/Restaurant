package com.springboot.restaurant.modules.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.user.dto.request.RoleCreateRequest;
import com.springboot.restaurant.modules.user.dto.request.RoleUpdateRequest;
import com.springboot.restaurant.modules.user.dto.response.RoleResponse;
import com.springboot.restaurant.modules.user.service.interfaces.RoleServiceInterface;
import com.springboot.restaurant.shared.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

    private final RoleServiceInterface roleService;

    public RoleController(RoleServiceInterface roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public ApiResponse<List<RoleResponse>> getRoles() {

        List<RoleResponse> roles = roleService.getList();

        return ApiResponse.success(200, "get list role success", roles);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<RoleResponse> postRole(@RequestBody @Valid RoleCreateRequest request) {

        RoleResponse dto = roleService.createdRole(request);

        return ApiResponse.success(201, "created role", dto);

    }

    @GetMapping("/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<RoleResponse> getRole(@PathVariable("roleId") Long id) {

        RoleResponse response = roleService.getRole(id);

        return ApiResponse.success(200, "find role success", response);

    }

    @PutMapping("/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<RoleResponse> putRole(@PathVariable("roleId") Long id, @RequestBody RoleUpdateRequest request) {

        RoleResponse response = roleService.updateRole(id, request);

        return ApiResponse.success(200, "update success", response);

    }

    @DeleteMapping("/{roleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<RoleResponse> deleteRole(@PathVariable("roleId") Long id) {

        RoleResponse response = roleService.deleteRole(id);

        return ApiResponse.success(204, "delete role success", response);
    }

}
