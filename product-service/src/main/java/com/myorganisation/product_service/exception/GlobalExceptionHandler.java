package com.myorganisation.product_service.exception;

import com.myorganisation.product_service.dto.response.GenericResponseDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponseDto> handleException(Exception ex)
    {
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setSuccess(false);
        genericResponseDto.setMessage("An exception Occurred: "+ ex.getMessage());
        return new ResponseEntity<>(genericResponseDto, HttpStatusCode.valueOf(400));
    }
}
