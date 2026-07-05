package com.springboot.restaurant.modules.users.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.restaurant.modules.users.dtos.request.UserCreationRequest;
import com.springboot.restaurant.modules.users.dtos.response.UserResponse;
import com.springboot.restaurant.modules.users.entities.Account;
import com.springboot.restaurant.modules.users.repositories.UserRepository;
import com.springboot.restaurant.modules.users.services.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getList() {
        List<Account> accounts = userRepository.findAll();
        System.out.println(accounts);
        return accounts.stream().map(account -> new UserResponse(
                account.getHoTen(),
                account.getNgaySinh(),
                account.getDiaChi(),
                account.getEmail()

        )).collect(Collectors.toList());

    }

    @Override
    public Account createdAt(@RequestBody UserCreationRequest request) {

        Account newacc = new Account();

        newacc.setTenDangNhap(request.getTenDangNhap());
        newacc.setMatKhau(request.getMatKhau());

        return userRepository.save(newacc);

    }

}
