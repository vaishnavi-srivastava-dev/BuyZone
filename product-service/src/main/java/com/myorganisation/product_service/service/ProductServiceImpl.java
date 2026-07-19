package com.myorganisation.product_service.service;

import com.myorganisation.product_service.dto.request.ProductRequestDto;
import com.myorganisation.product_service.dto.response.GenericResponseDto;
import com.myorganisation.product_service.dto.response.ProductResponseDto;
import com.myorganisation.product_service.entity.Product;
import com.myorganisation.product_service.exception.ProductNotFoundException;
import com.myorganisation.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    @CachePut(value = "product", key="#productRequestDto.id")
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        mapProductRequestDtoToProduct(productRequestDto,product);
        Product storedProduct = productRepo.save(product);
        return mapProductToProductResponseDto(product);
    }

    @Override
    @Cacheable(value = "product",key = "#id")
    public ProductResponseDto getProduct(Long id) {
        System.out.println("DB CALL HAPPENED");
        Product product = productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product of ID:- "+id+"does not exist."));
        return mapProductToProductResponseDto(product);
    }

    @Override
    @Cacheable(value = "products")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        List<ProductResponseDto> productResponseDtoList = new LinkedList<>();
        for(Product product: productList){
            ProductResponseDto productResponseDto=mapProductToProductResponseDto(product);
            productResponseDtoList.add(productResponseDto);
        }
        return productResponseDtoList;
    }

    @Override
    @CachePut(value = "product updated", key = "#id")
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepo.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product of id: " + id + " doesn't exist"
                        ));

        mapProductRequestDtoToProduct(productRequestDto, product);

        Product updatedProduct = productRepo.save(product);

        return mapProductToProductResponseDto(updatedProduct);    }

    @Override
    @CacheEvict(value = "product", key = "#id")
    public GenericResponseDto removeProduct(Long id) {
        Product product = productRepo.findById(id).orElse(null);
        GenericResponseDto genericResponseDto = new GenericResponseDto();

        if(product != null){
            String name = product.getName();
            productRepo.deleteById(id);
            genericResponseDto.setSuccess(true);
            genericResponseDto.setMessage("Product Name: "+name+" is deleted successfully!");
        }else {
            genericResponseDto.setSuccess(false);
            genericResponseDto.setMessage("Deletion of id: "+id+" failed!");
        }

        return genericResponseDto;    }

    //HELPER METHODS-
    private Product mapProductRequestDtoToProduct(ProductRequestDto productRequestDto,Product product){
        product.setName(productRequestDto.getName());
        product.setBrand(productRequestDto.getBrand());
        product.setPrice(productRequestDto.getPrice());
        product.setCategories(productRequestDto.getCategories());

        return product;
    }

    //MapProductToProductResponseDto
    private ProductResponseDto mapProductToProductResponseDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setId(product.getId());
        productResponseDto.setBrand(product.getBrand());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setCategories(product.getCategories());

        return productResponseDto;
    }
}
