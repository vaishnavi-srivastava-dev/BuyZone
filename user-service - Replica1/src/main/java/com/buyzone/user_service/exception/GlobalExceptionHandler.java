package com.buyzone.user_service.exception;

import com.buyzone.user_service.dto.response.GenericResponseDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<GenericResponseDto> handleUserNotFoundException(UserNotFoundException ex) {
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setSuccess(false);
        genericResponseDto.setMessage("detail"+ex.getMessage());

        return new ResponseEntity<>(genericResponseDto, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponseDto> handleException(Exception ex)
    {
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setSuccess(false);
        genericResponseDto.setMessage("An exception Occurred: "+ ex.getMessage());
        return new ResponseEntity<>(genericResponseDto,HttpStatusCode.valueOf(400));
    }
}
