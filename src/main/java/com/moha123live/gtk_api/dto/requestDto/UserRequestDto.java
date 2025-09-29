package com.moha123live.gtk_api.dto.requestDto;

import com.moha123live.gtk_api.model.User;
import com.moha123live.gtk_api.util.AppMessages;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserRequestDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Create {
        @NotBlank(message = AppMessages.USER_USERNAME_REQUIRED)
        @Size(min = 3, max = 50, message = AppMessages.USER_USERNAME_LENGTH)
        private String username;

        @NotBlank(message = AppMessages.USER_PASSWORD_REQUIRED)
        private String password;

        @NotBlank(message = AppMessages.USER_EMAIL_REQUIRED)
        @Email(message = AppMessages.USER_EMAIL_INVALID)
        @Size(max = 100, message = AppMessages.USER_EMAIL_LENGTH)
        private String email;

        private User.Role role;
        private User.Status status;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoleAndStatus {
        private User.Role role;
        private User.Status status;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Password {
        @NotBlank(message = AppMessages.USER_OLDPASSWORD_REQUIRED)
        private String oldPassword;

        @NotBlank(message = AppMessages.USER_NEWPASSWORD_REQUIRED)
        private String newPassword;
    }

}
