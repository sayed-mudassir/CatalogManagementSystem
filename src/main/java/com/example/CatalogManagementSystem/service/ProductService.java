package com.example.CatalogManagementSystem.service;


import com.example.CatalogManagementSystem.dto.request.ProductRequest;
import com.example.CatalogManagementSystem.dto.response.ProductResponse;
import com.example.CatalogManagementSystem.model.Product;

import java.util.List;

public interface ProductService {
    public ProductResponse addProduct(ProductRequest productRequest);
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public ProductResponse updateProduct(Long id, ProductRequest updatedProduct);
    public List<Product> getAllProductByBrand(String brand);
    public List<Product> getAllProductByCategory(String category);
    public List<Product> getALlProductByNameContaining(String keyword);
    public List<Product> getALlProductByPriceRange(Double min, Double max);
    public String deleteProduct(Long id);
//
}

