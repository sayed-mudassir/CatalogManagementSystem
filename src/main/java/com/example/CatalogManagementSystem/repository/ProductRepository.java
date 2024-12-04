package com.example.CatalogManagementSystem.repository;

import com.example.CatalogManagementSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrand(String brand);
    List<Product> findByCategory(String category);
    List<Product> findByNameContaining(String keyword);
}

