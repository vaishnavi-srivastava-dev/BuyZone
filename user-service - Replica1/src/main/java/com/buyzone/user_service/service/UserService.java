package com.buyzone.user_service.service;

import com.buyzone.user_service.dto.request.UserRequestDto;
import com.buyzone.user_service.dto.response.GenericResponseDto;
import com.buyzone.user_service.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto registerUser(UserRequestDto userRequestDto);
    UserResponseDto getUser(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id,UserRequestDto userRequestDto);
    GenericResponseDto removeUser(Long id);

}
