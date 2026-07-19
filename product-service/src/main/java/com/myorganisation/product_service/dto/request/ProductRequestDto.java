package com.myorganisation.product_service.dto.request;

import com.myorganisation.product_service.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class ProductRequestDto {

    @NotBlank(message="Name of the product is required")
    private String name;
    @NotBlank(message="Brand name is required")
    private String brand;
    @NotNull(message="Price is required")
    private Double price;
    @NotEmpty(message="category is required")
    private Set<Category> categories;
}
