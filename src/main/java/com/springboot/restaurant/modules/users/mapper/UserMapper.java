package com.springboot.restaurant.modules.users.mapper;

import com.springboot.restaurant.modules.users.dto.request.UserCreationRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserCreationResponse;
import com.springboot.restaurant.modules.users.dto.response.UserDeleteResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;
import com.springboot.restaurant.modules.users.dto.response.UserUpdateResponse;
import com.springboot.restaurant.modules.users.entity.Account;

public class UserMapper {
    public static UserResponse toUsersResponse(Account account) {

        UserResponse dto = new UserResponse();
        
        // nếu không set các trường thì trường đó sẽ hiện null khi truyền qua API
        dto.setMaTaiKhoan(account.getMaTaiKhoan());
        dto.setHoTen(account.getHoTen());
        dto.setDiaChi(account.getDiaChi());
        dto.setEmail(account.getEmail());
        dto.setNgaySinh(account.getNgaySinh());

        return dto;
    }

    public static Account toEntity(UserCreationRequest request) {

        Account account = new Account();

        account.setTenDangNhap(request.getTenDangNhap());
        account.setMatKhau(request.getMatKhau());
        account.setEmail(request.getEmail());

        return account;

    }
    
    public static void toEntity(UserUpdateRequest request, Account existsAccount) {
        
        existsAccount.setTenDangNhap(request.getTenDangNhap());
        existsAccount.setMatKhau(request.getMatKhau());
        existsAccount.setHoTen(request.getHoTen());
        existsAccount.setDiaChi(request.getDiaChi());
        existsAccount.setEmail(request.getEmail());
        
        
    }
    
    

    public static UserCreationResponse toUserCreationResponse(Account account) {
        UserCreationResponse dto = new UserCreationResponse();

        dto.setMatKhau(account.getMatKhau());
        dto.setTenDangNhap(account.getTenDangNhap());
        dto.setEmail(account.getEmail());
        return dto;

    }
    
    public static UserUpdateResponse toUserUpdateResponse(Account existsaccount) {

        UserUpdateResponse user = new UserUpdateResponse();
        user.setTenDangNhap(existsaccount.getTenDangNhap());
        user.setMatKhau(existsaccount.getMatKhau());
        user.setHoTen(existsaccount.getHoTen());
        user.setDiaChi(existsaccount.getDiaChi());
        user.setEmail(existsaccount.getEmail());
        return user;

    }
    
    
    public static UserDeleteResponse toUserDeleteResponse(Account existsAccount) {
        
        UserDeleteResponse user = new UserDeleteResponse();
        user.setMaTaiKhoan(existsAccount.getMaTaiKhoan());
        user.setTenDangNhap(existsAccount.getTenDangNhap());
        user.setEmail(existsAccount.getEmail());
        user.setHoTen(existsAccount.getHoTen());
        
        return user;
        
    }
    
    

}
