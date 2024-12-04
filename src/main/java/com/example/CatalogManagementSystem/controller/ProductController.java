package com.example.CatalogManagementSystem.controller;

import com.example.CatalogManagementSystem.dto.request.ProductRequest;
import com.example.CatalogManagementSystem.dto.response.ProductResponse;
import com.example.CatalogManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/product")
public class ProductController {
    final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity addProduct (@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(productService.addProduct(productRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id ){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@RequestBody ProductRequest productRequest , @PathVariable ("id") Long id ){
        return new ResponseEntity<>(productService.updateProduct(id,productRequest), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteProduct(@RequestParam Long id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.ACCEPTED);
    }

}
