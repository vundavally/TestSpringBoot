package com.poc.login.loginapp.service;

import com.poc.login.loginapp.modal.LoginRequest;
import com.poc.login.loginapp.modal.LoginResponse;
import com.poc.login.loginapp.modal.entity.UserEntity;

import java.util.List;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
    List<UserEntity> getUsers();
}
