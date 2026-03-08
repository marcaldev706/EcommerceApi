package com.ecommerce.app.product.service;

import com.ecommerce.app.product.entity.ProductEntity;
import com.ecommerce.app.product.exception.NoProductFound;
import com.ecommerce.app.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductEntity create(ProductEntity product) {
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public ProductEntity update(ProductEntity newProduct, Long id) {
        ProductEntity product = findById(id);

        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setDescription(newProduct.getDescription());
        product.setStock(newProduct.getStock());

        return productRepository.save(product);
    }

    public ProductEntity findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoProductFound(id));
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public void delete(Long id) {
        ProductEntity product = findById(id);

        productRepository.delete(product);
    }
}
