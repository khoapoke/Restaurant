package com.springboot.restaurant.modules.user.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.modules.user.entity.Account;
import com.springboot.restaurant.modules.user.repository.UserRepository;
import com.springboot.restaurant.modules.user.service.interfaces.AccountFacadeServiceInterface;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
@Service 
public class AccountFacadeService implements AccountFacadeServiceInterface {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public Account getAccountReference(Long maTaiKhoan) {

        return userRepository.getReferenceById(maTaiKhoan);
    }

}
