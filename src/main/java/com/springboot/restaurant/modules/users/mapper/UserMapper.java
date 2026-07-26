package com.springboot.restaurant.modules.users.mapper;

import com.springboot.restaurant.modules.users.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserCreateResponse;
import com.springboot.restaurant.modules.users.dto.response.UserDeleteResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;
import com.springboot.restaurant.modules.users.dto.response.UserUpdateResponse;
import com.springboot.restaurant.modules.users.entity.Account;

public class UserMapper {
    public static UserResponse toUserResponse(Account account) {
        
        UserResponse dto = new UserResponse();
        
        // note: if don't set variable there is will be null 
        dto.setMaTaiKhoan(account.getMaTaiKhoan());
        dto.setHoTen(account.getHoTen());
        dto.setDiaChi(account.getDiaChi());
        dto.setEmail(account.getEmail());
        dto.setNgaySinh(account.getNgaySinh());
        dto.setVaiTro(account.getVaiTro());
        return dto;
        
    }

    public static Account toEntity(UserCreateRequest request) {

        Account account = new Account();

        account.setTenDangNhap(request.getTenDangNhap());
        account.setMatKhau(request.getMatKhau());
        account.setEmail(request.getEmail());

        return account;

    }
    
    public static void toEntity(UserUpdateRequest request, Account existingAccount) {
        
        existingAccount.setTenDangNhap(request.getTenDangNhap());
        existingAccount.setMatKhau(request.getMatKhau());
        existingAccount.setHoTen(request.getHoTen());
        existingAccount.setDiaChi(request.getDiaChi());
        existingAccount.setEmail(request.getEmail());
        
    }

    public static UserCreateResponse toUserCreationResponse(Account account) {
       
        UserCreateResponse dto = new UserCreateResponse();

        dto.setMatKhau(account.getMatKhau());
        dto.setTenDangNhap(account.getTenDangNhap());
        dto.setEmail(account.getEmail());
        
        return dto;

    }
    
    public static UserUpdateResponse toUserUpdateResponse(Account existingAccount) {

        UserUpdateResponse user = new UserUpdateResponse();
        
        user.setTenDangNhap(existingAccount.getTenDangNhap());
        user.setMatKhau(existingAccount.getMatKhau());
        user.setHoTen(existingAccount.getHoTen());
        user.setDiaChi(existingAccount.getDiaChi());
        user.setEmail(existingAccount.getEmail());
        
        return user;

    }
    
    public static UserDeleteResponse toUserDeleteResponse(Account existingAccount) {
        
        UserDeleteResponse user = new UserDeleteResponse();
        
        user.setMaTaiKhoan(existingAccount.getMaTaiKhoan());
        user.setTenDangNhap(existingAccount.getTenDangNhap());
        user.setEmail(existingAccount.getEmail());
        user.setHoTen(existingAccount.getHoTen());
        
        return user;
        
    }
    
    

}
