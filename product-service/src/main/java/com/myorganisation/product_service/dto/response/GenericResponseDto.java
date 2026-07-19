package com.myorganisation.product_service.dto.response;

import lombok.Data;

@Data
public class GenericResponseDto {
    private Boolean success;
    private String message;
}
