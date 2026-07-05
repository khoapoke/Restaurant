package com.springboot.restaurant.modules.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    public AuthController() {
    }

    @PostMapping()
    public String login(@RequestBody String entity) {

        return entity;
    }

}
