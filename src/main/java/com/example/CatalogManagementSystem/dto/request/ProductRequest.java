package com.example.CatalogManagementSystem.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @Column(nullable = false) // @Column is used to restrict the column properties
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 40, message = "{validation.name.size.too_long}") // @Size annotation is used to restrict the min or max limit
    @NotBlank
    String name;

    @NotNull
    Integer quantity;

    @NotBlank
    String brand;


    @NotBlank
    String category; // we can also use ENUM instead of String

    String description;
    @NotNull
    Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
