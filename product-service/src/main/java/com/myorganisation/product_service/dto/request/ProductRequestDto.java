package com.myorganisation.product_service.dto.request;

import com.myorganisation.product_service.enums.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class ProductRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String brand;
    @NotBlank
    private Double price;
    @NotBlank
    private Set<Category> categories;
}
