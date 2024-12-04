package com.example.CatalogManagementSystem.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
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
}
