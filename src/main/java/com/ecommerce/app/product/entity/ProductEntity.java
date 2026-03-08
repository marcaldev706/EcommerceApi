package com.ecommerce.app.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
}
