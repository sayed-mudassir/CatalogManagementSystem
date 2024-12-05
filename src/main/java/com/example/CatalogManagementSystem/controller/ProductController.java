package com.example.CatalogManagementSystem.controller;

import com.example.CatalogManagementSystem.dto.request.ProductRequest;
import com.example.CatalogManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id ){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@RequestBody ProductRequest productRequest , @PathVariable ("id") Long id ){
        return new ResponseEntity<>(productService.updateProduct(id,productRequest), HttpStatus.OK);
    }

    @GetMapping("/get/brand/")
    public ResponseEntity getAllProductByBrand(@RequestParam  String brand ){
        return new ResponseEntity<>(productService.getAllProductByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/get/category/")
    public ResponseEntity getAllProductByCategory(@RequestParam  String category ){
        return new ResponseEntity<>(productService.getAllProductByCategory(category), HttpStatus.OK);
    }
    @GetMapping("/get/NameContaining/")
    public ResponseEntity getALlProductByNameContaining(@RequestParam String keyword){
        return new ResponseEntity<>(productService.getALlProductByNameContaining(keyword), HttpStatus.OK);
    }

    @GetMapping("/get/priceRange/")
    public ResponseEntity getALlProductByPriceRange(@RequestParam Double min, @RequestParam Double max){
        return new ResponseEntity<>(productService.getALlProductByPriceRange(min, max), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteProduct(@RequestParam Long id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.ACCEPTED);
    }

}
