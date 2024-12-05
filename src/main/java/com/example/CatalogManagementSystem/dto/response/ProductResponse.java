package com.example.CatalogManagementSystem.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
//@AllArgsConstructor
@NoArgsConstructor

public class ProductResponse {
    String name;

    Integer quantity;

    String brand;

    String category;

    String description;

    Double price;

    Date dateAdded;

    String msg;

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

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ProductResponse(String name,
                           Integer quantity,
                           String brand,
                           String category,
                           String description,
                           Double price,
                           Date dateAdded,
                           String msg) {
        this.name = name;
        this.quantity = quantity;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.price = price;
        this.dateAdded = dateAdded;
        this.msg = msg;
    }
}
