package com.example.CatalogManagementSystem.utils;

import com.example.CatalogManagementSystem.model.Product;
import com.example.CatalogManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class validationUtils {
    final ProductRepository productRepository;

    @Autowired
    public validationUtils(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean validateProductId(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.isPresent();
    }
}
