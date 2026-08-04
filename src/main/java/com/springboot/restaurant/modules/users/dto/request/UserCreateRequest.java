package com.springboot.restaurant.modules.users.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserCreateRequest {

    
    @Size(min = 3, message="username must be at least 3 characters")
    private String tenDangNhap;
    @Email(message = "email not formatted")
    private String email;
    @Size(min = 4, message="Passwors must be at least 4 characters")
    private String matKhau;
    
    private Long maVaiTro;

}
