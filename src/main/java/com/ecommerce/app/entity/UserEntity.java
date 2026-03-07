package com.ecommerce.app.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserEntity{
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String rg;
    private LocalDateTime createdAt;
}
