package com.example.CatalogManagementSystem.service.impl;

import com.example.CatalogManagementSystem.Exceptions.ProductNotFoundException;
import com.example.CatalogManagementSystem.dto.request.ProductRequest;
import com.example.CatalogManagementSystem.dto.response.ProductResponse;
import com.example.CatalogManagementSystem.model.Product;
import com.example.CatalogManagementSystem.repository.ProductRepository;
import com.example.CatalogManagementSystem.service.ProductService;
import com.example.CatalogManagementSystem.transfromer.ProductTransformer;
import com.example.CatalogManagementSystem.utils.validationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    /*
     * @Autowired
     * ProductRepository productRepository;
     * this is a field injection
     * we need to avoid this because it will create problem in testing
     * when mockito pass dummy bean it can throw null pointer exception
     */
    final ProductRepository productRepository;
    final validationUtils validationUtils;
    /*
     * instead of field injection I am using constructor injection
     * by making the bean as final and passing bean into the constructor
     * and instead of directly auto-wiring bean I am auto-wiring this injected bean constructor
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, com.example.CatalogManagementSystem.utils.validationUtils validationUtils) {
        this.productRepository = productRepository;
        this.validationUtils = validationUtils;
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = ProductTransformer.ProductRequestToProduct(productRequest);
        productRepository.save(product);
        return ProductTransformer.ProductToProductResponse(product,"product added successfully");
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        if(!validationUtils.validateProductId(id)){
            throw new ProductNotFoundException("invalid Product id");
        }
        return productRepository.findById(id).get();
    }
    @Override
    public ProductResponse updateProduct(Long id, ProductRequest updatedProduct) {
        if(!validationUtils.validateProductId(id)){
            throw new ProductNotFoundException("invalid Product id");
        }
        Product product = productRepository.findById(id).get();
        product.setBrand(updatedProduct.getBrand());
        product.setCategory(updatedProduct.getCategory());
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setQuantity(updatedProduct.getQuantity());
        productRepository.save(product);
        return ProductTransformer.ProductToProductResponse(product,"details updated");
    }

    @Override
    public List<Product> getAllProductByBrand(String brand) {
       return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getAllProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getALlProductByNameContaining(String keyword) {
        return productRepository.findProductsByNameContaining(keyword);
    }

    @Override
    public List<Product> getALlProductByPriceRange(Double min, Double max) {
        return productRepository.findProductsByPriceRange(min,max);
    }


    @Override
    public String deleteProduct(Long id) {
        if(!validationUtils.validateProductId(id)){
            throw new ProductNotFoundException("invalid Product id");
        }
        productRepository.deleteById(id);
        return "product deleted";
    }
}

