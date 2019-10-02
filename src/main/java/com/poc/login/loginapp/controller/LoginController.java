package com.poc.login.loginapp.controller;

import com.poc.login.loginapp.modal.LoginRequest;
import com.poc.login.loginapp.modal.LoginResponse;
import com.poc.login.loginapp.modal.entity.UserEntity;
import com.poc.login.loginapp.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(loginService.login(loginRequest), HttpStatus.OK);
    }

    @GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserEntity> getUsers(){
        return loginService.getUsers();
    }
}
