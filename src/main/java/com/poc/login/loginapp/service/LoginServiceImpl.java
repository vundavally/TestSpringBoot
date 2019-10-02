package com.poc.login.loginapp.service;

import com.poc.login.loginapp.exception.LoginException;
import com.poc.login.loginapp.modal.LoginRequest;
import com.poc.login.loginapp.modal.LoginResponse;
import com.poc.login.loginapp.modal.entity.UserEntity;
import com.poc.login.loginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.findByUsername(loginRequest.getUsername());

        if(userEntity == null) {
            throw new LoginException("Username or password incorrect");
        }

        if(!loginRequest.getPassword().equals(userEntity.getPassword())){
            throw new LoginException("password incorrect");
        }

        return new LoginResponse("Login Success");
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

}
