package com.springboot.restaurant.modules.user.dto.request;

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
public class UserUpdateRequest {
    
    // attributes can update
    @Size(min = 3, message="username must be at least 3 characters")
    private String tenDangNhap;

    private String hoTen;

    private String diaChi;
    @Email(message = "email not formatted")
    private String email;

    private Long maVaiTro;
    
}
