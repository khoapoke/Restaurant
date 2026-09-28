package com.springboot.restaurant.modules.users.mapper;

import org.springframework.stereotype.Component;

import com.springboot.restaurant.modules.users.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserDetailResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;
import com.springboot.restaurant.modules.users.entity.Account;

@Component

public class UserMapper {

    public UserResponse toUserResponse(Account account) {

        if (account == null)
            return null;
        UserResponse response = new UserResponse();

        // note: if don't set variable there is will be null
        response.setMaTaiKhoan(account.getMaTaiKhoan());
        response.setTenDangNhap(account.getTenDangNhap());
        response.setEmail(account.getEmail());
        response.setHoTen(account.getNguoiDung().getHoTen());
        response.setNgaySinh(account.getNguoiDung().getNgaySinh());

        return response;

    }

    public UserDetailResponse toUserDetailResponse(Account account) {
        if (account == null)
            return null;

        UserDetailResponse response = new UserDetailResponse();

        response.setMaTaiKhoan(account.getMaTaiKhoan());
        response.setTenDangNhap(account.getTenDangNhap());
        response.setEmail(account.getEmail());
        response.setDiaChi(account.getNguoiDung().getDiaChi());
        response.setHoTen(account.getNguoiDung().getHoTen());
        response.setNgaySinh(account.getNguoiDung().getNgaySinh());
        if (account.getVaiTro() != null) {
            response.setTenVaiTro(account.getVaiTro().getTenVaiTro());
        }

        return response;

    }

    public Account toEntity(UserCreateRequest request) {
        Account account = new Account();
        account.setTenDangNhap(request.getTenDangNhap());
        account.setMatKhau(request.getMatKhau());
        account.setEmail(request.getEmail());
        return account;

    }

    public void updateEntityFromRequest(UserUpdateRequest request, Account existingAccount) {

        existingAccount.setTenDangNhap(request.getTenDangNhap());
        existingAccount.getNguoiDung().setHoTen(request.getHoTen());
        existingAccount.getNguoiDung().setDiaChi(request.getDiaChi());
        existingAccount.setEmail(request.getEmail());

    }

    public UserResponse toUserCreationResponse(Account account) {
        if (account == null)
            return null;

        UserResponse dto = new UserResponse();
        dto.setMaTaiKhoan(account.getMaTaiKhoan());
        dto.setTenDangNhap(account.getTenDangNhap());
        dto.setEmail(account.getEmail());

        return dto;

    }

    public UserResponse toUserUpdateResponse(Account account) {
        UserResponse dto = new UserResponse();
        dto.setTenDangNhap(account.getTenDangNhap());
        dto.setHoTen(account.getNguoiDung().getHoTen());
        dto.setEmail(account.getEmail());

        return dto;

    }

    public UserResponse toUserDeleteResponse(Account account) {
        if (account == null)
            return null;

        UserResponse user = new UserResponse();
        user.setMaTaiKhoan(account.getMaTaiKhoan());

        return user;

    }

}
