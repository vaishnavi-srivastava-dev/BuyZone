package com.myorganisation.product_service.service;

import com.myorganisation.product_service.dto.request.ProductRequestDto;
import com.myorganisation.product_service.dto.response.GenericResponseDto;
import com.myorganisation.product_service.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
        ProductResponseDto addProduct(ProductRequestDto userRequestDto);
        ProductResponseDto getProduct(Long id);
        List<ProductResponseDto> getAllProducts();
        ProductResponseDto updateProduct(Long id,ProductRequestDto productRequestDto);
        GenericResponseDto removeProduct(Long id);

}
