package com.example.CatalogManagementSystem.repository;

import com.example.CatalogManagementSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrand(String brand);
    List<Product> findByCategory(String category);

    @Query("FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductsByPriceRange(Double minPrice, Double maxPrice);

    @Query("FROM Product p WHERE p.name LIKE %:keyword%")
    List<Product> findProductsByNameContaining(String keyword);
}

