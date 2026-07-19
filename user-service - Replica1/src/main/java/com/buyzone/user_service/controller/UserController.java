package com.buyzone.user_service.controller;

import com.buyzone.user_service.dto.request.UserRequestDto;
import com.buyzone.user_service.dto.response.GenericResponseDto;
import com.buyzone.user_service.dto.response.UserResponseDto;
import com.buyzone.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id)
    {
        return new ResponseEntity<>(userService.getUser(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatusCode.valueOf(200));
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.registerUser(userRequestDto),HttpStatusCode.valueOf(201));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.updateUser(id,userRequestDto),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<GenericResponseDto> deleteUser(@PathVariable(required = true) Long id){
        return new ResponseEntity<>(userService.removeUser(id),HttpStatusCode.valueOf(200));
    }
}
