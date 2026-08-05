package com.springboot.restaurant.modules.users.service.impl;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;

import com.springboot.restaurant.modules.menu.repository.FoodCategoryRepository;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.restaurant.modules.users.dto.request.UserCreateRequest;
import com.springboot.restaurant.modules.users.dto.request.UserUpdateRequest;
import com.springboot.restaurant.modules.users.dto.response.UserDetailResponse;
import com.springboot.restaurant.modules.users.dto.response.UserResponse;
import com.springboot.restaurant.modules.users.entity.Account;
import com.springboot.restaurant.modules.users.entity.Role;
import com.springboot.restaurant.modules.users.mapper.UserMapper;
import com.springboot.restaurant.modules.users.repository.RoleRepository;
import com.springboot.restaurant.modules.users.repository.UserRepository;
import com.springboot.restaurant.modules.users.service.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

    // @Transaction to rollback when it errol at database

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper,
            FoodCategoryRepository foodCategoryRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;

    }

    @Override
    public List<UserResponse> getList() {

        List<UserResponse> users = userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse).toList();

        return users;
    }

    @Override
    @Transactional
    public UserResponse createUser(UserCreateRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);

        }

        if (userRepository.existsByTenDangNhap(request.getTenDangNhap())) {
            throw new AppException(ErrorCode.TENDANGNHAP_EXISTED);
        }

        // create account to save to database
        Account account = userMapper.toEntity(request);
        if (request.getMaVaiTro() != null) {

            Role role = roleRepository.findById(request.getMaVaiTro())
                    .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

            account.setVaiTro(role);
        }
        Account saveAccount = userRepository.save(account);

        // create dto to save create request
        UserResponse user = userMapper.toUserCreationResponse(saveAccount);

        return user;

    }

    @Override
    public UserDetailResponse getUser(Long id) {

        Account account = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        UserDetailResponse user = userMapper.toUserDetailResponse(account);

        return user;

    }

    @Override
    @Transactional
    public UserResponse deleteUser(Long id) {

        Account account = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userRepository.delete(account);
        UserResponse user = userMapper.toUserDeleteResponse(account);

        return user;

    }

    @Override
    @Transactional
    public UserResponse updateUser(Long id, UserUpdateRequest request) {

        Account account = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        if (userRepository.existsByEmailAndMaTaiKhoanNot(request.getEmail(), id)) {

            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        if (userRepository.existsByTenDangNhapAndMaTaiKhoanNot(request.getTenDangNhap(), id)) {
            throw new AppException(ErrorCode.TENDANGNHAP_EXISTED);
        }

        // map user to enity account
        userMapper.updateEntityFromRequest(request, account);

        // // method 1: setMaVaiTro direct -> wrong, cause it set role object
        // account.getVaiTro().setMaVaiTro(request.getMaVaiTro());

        // method 2: check null and add role object
        if (request.getMaVaiTro() != null) {

            Role role = roleRepository.findById(request.getMaVaiTro())
                    .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

            account.setVaiTro(role);
        }

        // update and save enity
        Account saveAccount = userRepository.save(account);

        // map enity to response
        UserResponse user = userMapper.toUserUpdateResponse(saveAccount);

        return user;

    }
}
