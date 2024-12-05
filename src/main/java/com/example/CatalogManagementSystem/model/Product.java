package com.example.CatalogManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "product")

//@Data
/*
 * @Data annotation hold the properties of :
 * @Getters, @Setters and @RequiredArgsConstructor
 *
 */

//@Builder  //lombok is not working properly thats why I use mannual getters and setters

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false) // @Column is used to restrict the column properties
    @Size(min = 2, message = "{validation.name.size.too_short}")
    // @Size annotation is used to restrict the min or max limit
    @Size(max = 40, message = "{validation.name.size.too_long}")
    @NotBlank
    String name;

    @NotNull
    Integer quantity;
    /**
     * @NotNull Purpose: Ensures that the annotated field is not null. It does not impose any constraint on the actual content (e.g., empty or whitespace).
     */
    /**
     * @NotBlank Purpose: Ensures that the annotated field is not null and is not empty or made up only of whitespace.
     */
    @NotBlank
    String brand;


    @NotBlank
    String category; // we can also use ENUM instead of String

    String description;
    @NotNull
    Double price;

    @Temporal(TemporalType.TIMESTAMP)
    Date dateAdded = new Date();
    /**
     * @Temporal is used to specify the temporal precision of a java.util.Date or java.util.Calendar type field when it is persisted to the database.
     * @Temporal(TemporalType.TIMESTAMP):
     * Purpose: Maps a Date or Calendar to a database column that stores both the date and time.
     * TemporalType.TIMESTAMP: Specifies that the field should include both date and time components.
     */

////    Add Auditing Fields
    @LastModifiedDate
    Date updatedAt = new Date();

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

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

}
