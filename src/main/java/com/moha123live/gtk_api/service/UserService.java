package com.moha123live.gtk_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.moha123live.gtk_api.dto.requestDto.UserRequestDto;
import com.moha123live.gtk_api.dto.responseDto.UserResponseDto;
import com.moha123live.gtk_api.mapper.UserMapper;
import com.moha123live.gtk_api.model.User;
import com.moha123live.gtk_api.model.User.Role;
import com.moha123live.gtk_api.repository.UserRepository;
import com.moha123live.gtk_api.util.AppMessages;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create User by admin
    public UserResponseDto createUser(UserRequestDto.Create request) {
        if (userRepository.existsByUsernameIgnoreCase(request.getUsername())) {
            throw new IllegalArgumentException(request.getUsername() + " - " + AppMessages.USER_NAME_ALREADY_EXISTS);
        }
        if (userRepository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new IllegalArgumentException(request.getEmail() + " - " + AppMessages.USER_EMAIL_ALREADY_EXISTS);
        }

        User user = UserMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userRepository.save(user);
        return UserMapper.toResponseDto(saved);
    }

    // Get All the HELPER Role Users
    public List<UserResponseDto> getAllHelperUsers() {
        Role role = Role.valueOf("HELPER");
        List<User> users = userRepository.findByRole(role);
        List<UserResponseDto> responseList = new ArrayList<>();
        for (User user : users) {
            responseList.add(UserMapper.toResponseDto(user));
        }
        return responseList;
    }

    // Get by ID
    public UserResponseDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(AppMessages.USER_NOT_FOUND));
        return UserMapper.toResponseDto(user);
    }

    // Update user role and status
    public UserResponseDto updateUserRoleAndStatus(Integer id, UserRequestDto.RoleAndStatus request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(AppMessages.USER_NOT_FOUND));
        existingUser.setRole(request.getRole());
        existingUser.setStatus(request.getStatus());
        User data = userRepository.save(existingUser);
        return UserMapper.toResponseDto(data);
    }

    // Update user password by admin
    public UserResponseDto updatePasswordByAdmin(Integer id, String password) {
        // Check here this end point is accessed by admin only.
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(AppMessages.USER_NOT_FOUND));
        existingUser.setPassword(passwordEncoder.encode(password));
        User data = userRepository.save(existingUser);
        return UserMapper.toResponseDto(data);
    }

    //this route will be access only by the helper user
    public UserResponseDto updatePassword(Integer id, UserRequestDto.Password req ) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(AppMessages.USER_NOT_FOUND));
        if (!passwordEncoder.matches(req.getOldPassword(), existingUser.getPassword())) {
            throw new IllegalArgumentException(AppMessages.USER_INCORRECT_PASSWORD);
        }
        existingUser.setPassword(passwordEncoder.encode(req.getNewPassword()));
        User data = userRepository.save(existingUser);
        return UserMapper.toResponseDto(data);
    }

    // Delete User by admin only
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException(AppMessages.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }
}
