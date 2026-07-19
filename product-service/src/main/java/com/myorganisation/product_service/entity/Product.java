package com.myorganisation.product_service.entity;

import com.myorganisation.product_service.enums.Category;
import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private Double price;

    @Column(name = "categories")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable( name = "product_categories")
    private Set<Category> categories = new HashSet<>();


}
