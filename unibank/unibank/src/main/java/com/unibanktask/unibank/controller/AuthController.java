package com.unibanktask.unibank.controller;

import com.unibanktask.unibank.dto.JWTAuthResponse;
import com.unibanktask.unibank.dto.UserDto;
import com.unibanktask.unibank.dto.request.LoginRequest;
import com.unibanktask.unibank.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login"})
    @Operation(summary = "Login")
    @SecurityRequirement(name = "jwt")
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginRequest loginRequest){
        String token = userService.login(loginRequest);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = {"/register"})
    @Operation(summary = "Register")
    public ResponseEntity<String> register(@Valid @RequestBody UserDto userDto){
        String response = userService.createUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
