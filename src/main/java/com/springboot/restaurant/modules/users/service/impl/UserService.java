package com.springboot.restaurant.modules.users.service.impl;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.springboot.restaurant.modules.users.dto.request.UserCreationRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserCreationResponse;
import com.springboot.restaurant.modules.users.dto.response.UserDeleteResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;
import com.springboot.restaurant.modules.users.dto.response.UserUpdateResponse;
import com.springboot.restaurant.modules.users.entity.Account;
import com.springboot.restaurant.modules.users.mapper.UserMapper;
import com.springboot.restaurant.modules.users.repository.UserRepository;
import com.springboot.restaurant.modules.users.service.interfaces.UserServiceInterface;



@Service
public class UserService implements UserServiceInterface {

    // @Transaction to rollback when it errol at database
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
       
    }

    @Override
    public List<UserResponse> getList() {
        
        return userRepository.findAll()
        .stream()
        .map(UserMapper::toUsersResponse).toList();
    }

    @Override
    @Transactional
    public UserCreationResponse createUser(UserCreationRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);

        }
        
          if (userRepository.existsByTenDangNhap(request.getTenDangNhap())) {
            throw new AppException(ErrorCode.TENDANGNHAP_EXISTED);
        }
        
        
        
        // tạo acc entity để lưu xuống database
        Account account = UserMapper.toEntity(request);

        userRepository.save(account);

        // tạo lại dto, rồi dùng dto đó lưa lại enity để hiển thị response
        UserCreationResponse user = UserMapper.toUserCreationResponse(account);

        return user;

    }
    
    @Override
    public UserResponse getUser(Long id) {
        
        Account account = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        UserResponse user = UserMapper.toUsersResponse(account);
        return user;

    }
    
    @Override
    @Transactional
    public UserDeleteResponse deleteUser(Long id) {

        Account account = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userRepository.delete(account);
        UserDeleteResponse user = UserMapper.toUserDeleteResponse(account);
        
        return user;
        
    }

    @Override
    @Transactional
    public UserUpdateResponse updateUser(Long id, UserUpdateRequest request) {
        
        Account account=userRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_FOUND));
       
        if (userRepository.existsByEmail(request.getEmail())) {

            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        if (userRepository.existsByTenDangNhap(request.getTenDangNhap())) {
            throw new AppException(ErrorCode.TENDANGNHAP_EXISTED);
        }
        
        
        //map user to enity account
        
        UserMapper.toEntity(request, account);
        
        // update and save enity
        userRepository.save(account);
        
        // map enity to response
        UserUpdateResponse user =UserMapper.toUserUpdateResponse(account);
        
        return user;
        
        
    }
}
