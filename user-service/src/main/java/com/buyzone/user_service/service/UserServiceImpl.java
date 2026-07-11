package com.buyzone.user_service.service;

import com.buyzone.user_service.dto.request.UserRequestDto;
import com.buyzone.user_service.dto.response.GenericResponseDto;
import com.buyzone.user_service.dto.response.UserResponseDto;
import com.buyzone.user_service.entity.User;
import com.buyzone.user_service.exception.UserNotFoundException;
import com.buyzone.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository ;
    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        User user = new User();
        mapUserRequestDtoToUser(userRequestDto,user);
        User storedUser = userRepository.save(user);
        return mapUserToUserResponseDto(storedUser);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User of id: "+id+" doesn't exist"));
        return mapUserToUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new LinkedList<>();
        for(User user: userList){
            UserResponseDto userResponseDto=mapUserToUserResponseDto(user);
            userResponseDtoList.add(userResponseDto);
        }
        return userResponseDtoList;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User of id: "+id+" doesn't exist"));
        mapUserRequestDtoToUser(userRequestDto,user);
        userRepository.save(user);
        return mapUserToUserResponseDto(user);
    }

    @Override
    public GenericResponseDto removeUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        GenericResponseDto genericResponseDto = new GenericResponseDto();

        if(user != null){
            String name = user.getName();
            userRepository.deleteById(id);
            genericResponseDto.setSuccess(true);
            genericResponseDto.setMessage("UserName: "+name+" is deleted successfully!");
        }else {
            genericResponseDto.setSuccess(false);
            genericResponseDto.setMessage("Deletion of id: "+id+" failed!");
        }

        return genericResponseDto;
    }


    //HELPER METHODS
    //MapUserRequestDtoToUser
    private User mapUserRequestDtoToUser(UserRequestDto userRequestDto, User user){
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setAddress(userRequestDto.getAddress());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setPhone(userRequestDto.getPhone());
        user.setGender(userRequestDto.getGender());
        user.setRole(userRequestDto.getRole());

        return user;
    }

    //MapUserToUserResponseDto
    private UserResponseDto mapUserToUserResponseDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setAddress(user.getAddress());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setGender(user.getGender());
        userResponseDto.setRole(user.getRole());

        return userResponseDto;
    }
}
