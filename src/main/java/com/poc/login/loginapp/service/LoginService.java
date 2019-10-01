package com.poc.login.loginapp.service;

import com.poc.login.loginapp.modal.LoginRequest;
import com.poc.login.loginapp.modal.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoginService {
    ResponseEntity<String> login(LoginRequest loginRequest);
    List<UserEntity> getUsers();
}
