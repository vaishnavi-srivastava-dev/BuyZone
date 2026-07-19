package com.myorganisation.product_service.controller;

import com.myorganisation.product_service.dto.request.ProductRequestDto;
import com.myorganisation.product_service.dto.response.GenericResponseDto;
import com.myorganisation.product_service.dto.response.ProductResponseDto;
import com.myorganisation.product_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponseDto> addProduct(@Valid @RequestBody ProductRequestDto productRequestDto){
        return new ResponseEntity<>(productService.addProduct(productRequestDto),HttpStatusCode.valueOf(201));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id)
    {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto){
        return new ResponseEntity<>(productService.updateProduct(id,productRequestDto),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<GenericResponseDto> deleteProduct(@PathVariable(required = true) Long id){
        return new ResponseEntity<>(productService.removeProduct(id),HttpStatusCode.valueOf(200));
    }
}
