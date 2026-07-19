package com.buyzone.user_service.dto.response;

import com.buyzone.user_service.enums.Gender;
import com.buyzone.user_service.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Gender gender;
    private Set<Role> role;
}
