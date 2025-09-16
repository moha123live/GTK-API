package com.moha123live.gtk_api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moha123live.gtk_api.dto.requestDto.LoginRequestDto;
import com.moha123live.gtk_api.dto.requestDto.UserRequestDto;
import com.moha123live.gtk_api.dto.responseDto.ApiResponse;
import com.moha123live.gtk_api.dto.responseDto.UserResponseDto;
import com.moha123live.gtk_api.security.JwtUtil;
import com.moha123live.gtk_api.service.CustomUserDetailsService;
import com.moha123live.gtk_api.service.UserService;
import com.moha123live.gtk_api.util.ApiResponseUtil;
import com.moha123live.gtk_api.util.AppMessages;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Map<String, String>>> login(@Valid @RequestBody LoginRequestDto loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.USER_LOGIN_SUCCESS, Map.of("token", jwt)));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@Valid @RequestBody UserRequestDto.Create request) {
        UserResponseDto response = userService.createUser(request);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.USER_CREATED, response));
    }
}
