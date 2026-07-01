package com.springboot.restaurant.modules.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.restaurant.BaseController;

@RequestMapping("api/v1/users")
public class UserController extends BaseController {

    @GetMapping("")
    public String getList() {
        return "hello";

    }

}
