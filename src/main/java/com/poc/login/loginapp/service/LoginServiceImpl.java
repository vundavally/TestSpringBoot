package com.poc.login.loginapp.service;

import com.poc.login.loginapp.modal.LoginRequest;
import com.poc.login.loginapp.modal.entity.UserEntity;
import com.poc.login.loginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> login(LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.findByUsername(loginRequest.getUsername());

        if(userEntity == null) {
            return new ResponseEntity<>("Username or password incorrect", HttpStatus.FORBIDDEN);
        }

        if(!loginRequest.getPassword().equals(userEntity.getPassword())){
            return new ResponseEntity<>("password incorrect", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>("Login Success", HttpStatus.OK);
    }

    @Override
    public List<UserEntity> getUsers() {
//        return userRepository.findByUsername("swetha");
        return userRepository.findAll();
    }

}
