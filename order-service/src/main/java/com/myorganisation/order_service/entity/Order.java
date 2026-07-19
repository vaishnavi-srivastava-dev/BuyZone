package com.myorganisation.order_service.entity;

import com.myorganisation.order_service.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private Long userId;

    private List<OrderItem> items;

    private Double totalAmount;

    private Status status;

    private LocalDateTime createdAt;
}
