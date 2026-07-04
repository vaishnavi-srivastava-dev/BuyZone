package com.buyzone.user_service.entity;

import com.buyzone.user_service.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;
    private String password;
    private String address;

    @Column(unique = true)
    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}