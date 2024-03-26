package com.focus_group.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Schema(description = "Request for resetting password")
public record NewPasswordRequest(
        @Schema(minLength = 8, maxLength = 255, description = "New password", requiredMode = Schema.RequiredMode.REQUIRED, example = "MySecurePassword123@!", pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
        @NotBlank(message = "Password cannot be blank")
        @Length(min = 8, max = 255, message = "Password length must be less than or equal to 255 characters")
        @JsonProperty(required = true)
        String password,

        @Schema(minLength = 8, description = "Confirm new password", requiredMode = Schema.RequiredMode.REQUIRED, example = "MySecurePassword123@!", maxLength = 255)
        @NotBlank(message = "Confirm password cannot be blank")
        @Length(min = 8, max = 255, message = "Confirm password length must be less than or equal to 255 characters")
        @JsonProperty(required = true)
        String confirmPassword
) implements Serializable {
}
