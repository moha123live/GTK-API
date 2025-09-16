package com.moha123live.gtk_api.controller;

import com.moha123live.gtk_api.dto.requestDto.UserRequestDto;
import com.moha123live.gtk_api.dto.responseDto.ApiResponse;
import com.moha123live.gtk_api.dto.responseDto.UserResponseDto;
import com.moha123live.gtk_api.service.UserService;
import com.moha123live.gtk_api.util.ApiResponseUtil;
import com.moha123live.gtk_api.util.AppMessages;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getAllHelperUsers() {
        List<UserResponseDto> response = userService.getAllHelperUsers();
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.USERS_FETCHED, response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable Integer id) {
        UserResponseDto response = userService.getUserById(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.USER_FETCHED,response));
    }

    @PutMapping("/{id}/role-status")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUserRoleAndStatus(@PathVariable Integer id, @Valid @RequestBody UserRequestDto.RoleAndStatus user) {
        UserResponseDto response = userService.updateUserRoleAndStatus(id, user);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.USER_UPDATED,response));
    }

    @PutMapping("/{id}/password/admin")
    public ResponseEntity<ApiResponse<UserResponseDto>> updatePasswordByAdmin(@PathVariable Integer id, @RequestBody String password) {
        UserResponseDto response = userService.updatePasswordByAdmin(id, password);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.USER_UPDATED,response));
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<ApiResponse<UserResponseDto>> updatePassword(@PathVariable Integer id, @Valid @RequestBody UserRequestDto.Password user) {
        UserResponseDto response = userService.updatePassword(id, user);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.USER_UPDATED,response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.USER_DELETED, null));
    }

}
