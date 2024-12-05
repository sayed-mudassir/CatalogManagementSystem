package com.example.CatalogManagementSystem.transfromer;

import com.example.CatalogManagementSystem.dto.request.ProductRequest;
import com.example.CatalogManagementSystem.dto.response.ProductResponse;
import com.example.CatalogManagementSystem.model.Product;

public class ProductTransformer {
    public static Product ProductRequestToProduct(ProductRequest productRequest){

//        return Product.builder()
//                .name(productRequest.getName())
//                .price(productRequest.getPrice())
//                .description(productRequest.getDescription())
//                .category(productRequest.getCategory())
//                .quantity(productRequest.getQuantity())
//                .brand(productRequest.getBrand())
//                .build();
        Product product = new Product();
        product.setBrand(productRequest.getBrand());
        product.setCategory(productRequest.getCategory());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setQuantity(productRequest.getQuantity());
        return product;
    }
    public static ProductResponse ProductToProductResponse(Product product, String msg){

        ProductResponse productResponse = new ProductResponse(
                product.getName(),
                product.getQuantity(),
                product.getBrand(),
                product.getCategory(),
                product.getDescription(),
                product.getPrice(),
                product.getDateAdded(),
                msg);

                return productResponse;
    }
}
