package com.poc.login.loginapp.controller;

import com.poc.login.loginapp.modal.LoginRequest;
import com.poc.login.loginapp.modal.entity.UserEntity;
import com.poc.login.loginapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }

    @GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserEntity> getUsers(){
        return loginService.getUsers();
    }

}
