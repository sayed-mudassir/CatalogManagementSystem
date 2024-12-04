package com.example.CatalogManagementSystem.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Name is mandatory")
    String name;

    @Min(value = 1, message = "Quantity must be at least 1")
    Integer quantity;

    @NotBlank(message = "Brand is mandatory")
    String brand;

    @NotBlank(message = "Category is mandatory")
    String category;

    String description;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    Double price;
}
