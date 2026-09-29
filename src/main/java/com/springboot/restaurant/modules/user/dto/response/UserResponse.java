package com.springboot.restaurant.modules.user.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    
    private Long maTaiKhoan;
    private String tenDangNhap;
    
    private String email;
    private String hoTen;
    private LocalDate ngaySinh;


}
