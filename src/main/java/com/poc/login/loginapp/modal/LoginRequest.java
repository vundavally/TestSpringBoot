package com.poc.login.loginapp.modal;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {
    @NotEmpty(message = "Username should not be null or empty.")
    private String username;
    @NotEmpty(message = "Password should not be null or empty.")
    private String password;
}
