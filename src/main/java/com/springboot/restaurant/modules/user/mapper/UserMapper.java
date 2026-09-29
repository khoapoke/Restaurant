package com.springboot.restaurant.modules.user.mapper;

import org.springframework.stereotype.Component;

import com.springboot.restaurant.modules.user.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.user.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.user.dto.response.UserDetailResponse;
import com.springboot.restaurant.modules.user.dto.response.UserResponse;
import com.springboot.restaurant.modules.user.entity.Account;

@Component

public class UserMapper {

    public Account toEntityAccount(UserCreateRequest request) {
        if(request==null)
            return null;
        Account account = new Account();
        account.setTenDangNhap(request.getTenDangNhap());
        account.setMatKhau(request.getMatKhau());
        account.setEmail(request.getEmail());
        return account;

    }

    // bị nhầm giữa account và user sẽ refactor lại sau 
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

    public void updateEntityFromRequest(UserUpdateRequest request, Account existingAccount) {

        existingAccount.setTenDangNhap(request.getTenDangNhap());
        existingAccount.getNguoiDung().setHoTen(request.getHoTen());
        existingAccount.getNguoiDung().setDiaChi(request.getDiaChi());
        existingAccount.setEmail(request.getEmail());

    }

  

}
