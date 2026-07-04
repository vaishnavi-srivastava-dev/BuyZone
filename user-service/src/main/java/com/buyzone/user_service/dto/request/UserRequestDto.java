package com.buyzone.user_service.dto.request;

import com.buyzone.user_service.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    //@Pattern(regexp = "^[A-Za-z]")
    private String name;
    @NotBlank
    private String password;
    @NotNull
    private String address;

    @NotNull
    @Pattern( regexp = "^[6-9]\\d{9}$")
    private String phone;

    @NotBlank
    @Email(message = "Invalid Email Address")
    @Size(min = 8, max = 100, message = "Email must be between 8 to 100 characters")
    private String email;

    @NotNull(message = "Gender is required")
    private Gender gender;
}
