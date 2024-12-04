package com.example.CatalogManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@AllArgsConstructor
@Data
/*
 * @Data annotation hold the properties of :
 * @Getters, @Setters and @RequiredArgsConstructor
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Table(name = "product")

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

    @NotBlank
    String brand;
    /**
     * @NotBlank Purpose: Ensures that the annotated field is not null and is not empty or made up only of whitespace.
     */

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
//    @CreatedDate
//    private Date createdAt;
//
//    @LastModifiedDate
//    private Date updatedAt;

}
