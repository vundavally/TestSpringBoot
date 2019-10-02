package com.poc.login.loginapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.login.loginapp.modal.LoginRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper objectMapper;

    private LoginRequest loginRequest;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testLoginSuccess() throws Exception {
        loginRequest = new LoginRequest();
        loginRequest.setUsername("krishna");
        loginRequest.setPassword("password1");

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(loginRequest)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.message").value("Login Success"));

    }

    @Test
    public void testLogin_UserNotFound() throws Exception {
        loginRequest = new LoginRequest();
        loginRequest.setUsername("krishna1");
        loginRequest.setPassword("password1");

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(loginRequest)))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").value("Username or password incorrect"));

    }

    @Test
    public void testLogin_WrongPassword() throws Exception {
        loginRequest = new LoginRequest();
        loginRequest.setUsername("krishna");
        loginRequest.setPassword("password");

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(loginRequest)))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").value("password incorrect"));
    }

    @Test
    public void testLogin_InvalidInput_BlankUserName() throws Exception{
        loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("password");

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(loginRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testLogin_InvalidInput_BlankPassword() throws Exception{
        loginRequest = new LoginRequest();
        loginRequest.setUsername("test");
        loginRequest.setPassword("");

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(loginRequest)))
                .andExpect(status().isBadRequest());
    }
}
