package com.springboot.restaurant.modules.users.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.modules.users.dto.request.UserCreationRequest;
import com.springboot.restaurant.modules.users.dto.response.UserCreationResponse;

import com.springboot.restaurant.modules.users.dto.response.UsersResponse;
import com.springboot.restaurant.modules.users.entity.Account;
import com.springboot.restaurant.modules.users.mapper.UserMapper;
import com.springboot.restaurant.modules.users.repository.UserRepository;
import com.springboot.restaurant.modules.users.service.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public List<UsersResponse> getList() {
        List<Account> accounts = userRepository.findAll();
        // System.out.println(accounts);
        return accounts.stream().map(UserMapper::toUsersResponse).toList();
    }

    @Override
    public UserCreationResponse createUser(UserCreationRequest request) {

        // tạo acc entity để lưu xuống database
        Account newacc = UserMapper.toEntity(request);

        userRepository.save(newacc);

        // tạo dto dto lưa lại enity hiển thị cho response
        UserCreationResponse response = UserMapper.toUserCreationResponse(newacc);

        return response;

    }
    
    @Override
    public UsersResponse getUser(Long id) {
        Account account = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        
        UsersResponse user = UserMapper.toUsersResponse(account);
        return user;
        
        
        
    }
    

}
