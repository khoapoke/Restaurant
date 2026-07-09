package com.springboot.restaurant.modules.users.mapper;

import com.springboot.restaurant.modules.users.dto.request.UserCreationRequest;
import com.springboot.restaurant.modules.users.dto.response.UserCreationResponse;
import com.springboot.restaurant.modules.users.dto.response.UsersResponse;
import com.springboot.restaurant.modules.users.entity.Account;

public class UserMapper {
    public static UsersResponse toUsersResponse(Account account) {

        UsersResponse dto = new UsersResponse();
        
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

        return account;

    }

    public static UserCreationResponse toUserCreationResponse(Account account) {
        UserCreationResponse dto = new UserCreationResponse();

        dto.setMatKhau(account.getMatKhau());
        dto.setTenDangNhap(account.getTenDangNhap());
        dto.setEmail(account.getEmail());
        return dto;

    }

}
