package com.ecommerce.app.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name must not be blank")
    @Size(max = 120, message = "Product name must have at most 120 characters")
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @NotBlank(message = "Description must not be blank")
    @Size(max = 500, message = "Description must have at most 500 characters")
    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @NotNull(message = "Price must not be null")
    @Positive(message = "Price must be greater than zero")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotNull(message = "Stock must not be null")
    @PositiveOrZero(message = "Stock must be zero or greater")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}