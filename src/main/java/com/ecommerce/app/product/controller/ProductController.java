package com.ecommerce.app.product.controller;

import com.ecommerce.app.product.entity.ProductEntity;
import com.ecommerce.app.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductEntity> create(@RequestBody @Valid ProductEntity product) {

        ProductEntity savedProduct = productService.create(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> update(@RequestBody @Valid ProductEntity newProduct,
                                                @PathVariable Long id) {

        ProductEntity updatedProduct = productService.update(newProduct, id);

        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id) {

        ProductEntity productById = productService.findById(id);

        return ResponseEntity.ok(productById);
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll() {

        return ResponseEntity.ok(productService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}