package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.requestDto.UserRequestDto;
import com.moha123live.gtk_api.dto.responseDto.UserResponseDto;
import com.moha123live.gtk_api.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDto.Create req) {
        if (req == null) return null;
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setEmail(req.getEmail());
        user.setRole(req.getRole());
        if (req.getStatus() != null) {
            user.setStatus(req.getStatus());
        }
        return user;
    }

    public static UserResponseDto toResponseDto(User res) {
        if (res == null) return null;
        return UserResponseDto.builder()
                .id(res.getUserId())
                .username(res.getUsername())
                .email(res.getEmail())
                .role(res.getRole().name())
                .status(res.getStatus().name())
                .build();
    }
}
