package com.example.CatalogManagementSystem.service.impl;

import com.example.CatalogManagementSystem.Exceptions.ProductNotFoundException;
import com.example.CatalogManagementSystem.dto.request.ProductRequest;
import com.example.CatalogManagementSystem.dto.response.ProductResponse;
import com.example.CatalogManagementSystem.model.Product;
import com.example.CatalogManagementSystem.repository.ProductRepository;
import com.example.CatalogManagementSystem.service.ProductService;
import com.example.CatalogManagementSystem.transfromer.ProductTransformer;
import com.example.CatalogManagementSystem.utils.validationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
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
        logger.info("Adding new product: {}", productRequest.getName());
        Product product = ProductTransformer.ProductRequestToProduct(productRequest);
        productRepository.save(product);
        logger.info("Added new product: {}" ,product.getDateAdded());
        return ProductTransformer.ProductToProductResponse(product,"product added successfully");
    }

    @Override
    public List<Product> getAllProducts() {
        logger.info("Fetching all products from the catalog.");
        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            logger.warn("No products found in the catalog.");
        } else {
            logger.info("Successfully fetched {} products.", products.size());
        }

        return products;
    }

    @Override
    public Product getProductById(Long id) {
        logger.debug("Retrieving product with ID: {}", id);
        if(!validationUtils.validateProductId(id)){
            throw new ProductNotFoundException("invalid Product id");
        }
        logger.info("product found with ID: {}", id);
        return productRepository.findById(id).get();
    }
    @Override
    public ProductResponse updateProduct(Long id, ProductRequest updatedProduct) {
        logger.info("Attempting to update product with ID: {}", id);
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
        product.setUpdatedAt(new Date());
        productRepository.save(product);
        logger.info("Successfully updated product with ID: {} at {}", id, product.getUpdatedAt());
        return ProductTransformer.ProductToProductResponse(product,"details updated");
    }

    @Override
    public List<Product> getAllProductByBrand(String brand) {
        logger.info("Fetching products with brand: {}", brand);

        List<Product> products = productRepository.findByBrand(brand);

        if (products.isEmpty()) {
            logger.warn("No products found with brand: {}", brand);
        } else {
            logger.info("Successfully fetched {} products with brand: {}", products.size(), brand);
        }

        return products;
    }

    @Override
    public List<Product> getAllProductByCategory(String category) {
        logger.info("Fetching products with category: {}", category);

        List<Product> products = productRepository.findByCategory(category);

        if (products.isEmpty()) {
            logger.warn("No products found with category: {}", category);
        } else {
            logger.info("Successfully fetched {} products with category: {}", products.size(), category);
        }

        return products;
    }

    @Override
    public List<Product> getALlProductByNameContaining(String keyword) {
        logger.info("Fetching products containing the keyword: {}", keyword);

        List<Product> products = productRepository.findProductsByNameContaining(keyword);

        if (products.isEmpty()) {
            logger.warn("No products found containing the keyword: {}", keyword);
        } else {
            logger.info("Successfully fetched {} products containing the keyword: {}", products.size(), keyword);
        }

        return products;
    }

    @Override
    public List<Product> getALlProductByPriceRange(Double min, Double max) {
        logger.info("Fetching products within the price range: {} - {}", min, max);

        List<Product> products = productRepository.findProductsByPriceRange(min, max);

        if (products.isEmpty()) {
            logger.warn("No products found within the price range: {} - {}", min, max);
        } else {
            logger.info("Successfully fetched {} products within the price range: {} - {}", products.size(), min, max);
        }

        return products;
    }


    @Override
    public String deleteProduct(Long id) {
        logger.warn("Attempting to delete product with ID: {}", id);
        if(!validationUtils.validateProductId(id)){
            throw new ProductNotFoundException("invalid Product id");
        }
        productRepository.deleteById(id);
        logger.info("Successfully deleted product with ID: {}", id);
        return "product deleted";
    }
}

