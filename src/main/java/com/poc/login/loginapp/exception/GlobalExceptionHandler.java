package com.poc.login.loginapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<?> handleESignatureException(HttpServletRequest request, LoginException ex) {
        log.error("LoginException in processing the request - {}", ex.getMessage());

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }
}
