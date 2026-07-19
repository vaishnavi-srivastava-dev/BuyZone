package com.myorganisation.product_service.exception;

public class ProductNotFoundException extends RuntimeException{

    //default constructor
    public ProductNotFoundException() {
        super("Product Not Found!");
    }

    //parameterised constructor
    public ProductNotFoundException(String m) {
        super(m);
    }
}
