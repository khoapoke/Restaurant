package com.springboot.restaurant.modules.user.service.interfaces;

import com.springboot.restaurant.modules.user.entity.Account;

public interface AccountFacadeServiceInterface {


    Account getAccountReference(Long maTaiKhoan);
    
}
