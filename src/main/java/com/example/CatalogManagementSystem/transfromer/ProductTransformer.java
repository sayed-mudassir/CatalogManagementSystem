package com.example.CatalogManagementSystem.transfromer;

import com.example.CatalogManagementSystem.dto.request.ProductRequest;
import com.example.CatalogManagementSystem.dto.response.ProductResponse;
import com.example.CatalogManagementSystem.model.Product;

public class ProductTransformer {
    public static Product ProductRequestToProduct(ProductRequest productRequest){

        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .category(productRequest.getCategory())
                .quantity(productRequest.getQuantity())
                .brand(productRequest.getBrand())
//                .createdAt(dateAdded)
                .build();
//        Product product = new Product();
//        product.setQuantity(productRequest.getQuantity());
//        product.setCategory(productRequest.getCategory());
//        return product;
    }
    public static ProductResponse ProductToProductResponse(Product product, String msg){
        return ProductResponse.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .dateAdded(product.getDateAdded())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .msg(msg)
                .build();
    }
}
