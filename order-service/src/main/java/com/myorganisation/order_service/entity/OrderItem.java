package com.myorganisation.order_service.entity;

import lombok.Data;

@Data
public class OrderItem {

    private Long productId;

    private String productName;

    private Double price;

    private Integer quantity;

}