package com.myorganisation.product_service.repository;

import com.myorganisation.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ProductRepo extends JpaRepository<Product,Long> {
}
