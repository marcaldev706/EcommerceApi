package com.ecommerce.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 80)
    private String name;
    @Column(name = "email", nullable = false, length = 80, unique = true)
    private String email;
    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(name = "rg", nullable = false, length = 11, unique = true)
    private String rg;
    @Column(name = "date_creation", nullable = false)
    private LocalDateTime createdAt;
}
