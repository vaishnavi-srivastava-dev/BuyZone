package com.myorganisation.product_service.dto.response;

import com.myorganisation.product_service.enums.Category;
import lombok.Data;

import java.util.Set;

@Data
public class ProductResponseDto {
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Set<Category> categories;
}
