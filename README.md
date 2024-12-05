# *Catalog Management System*

A Spring Boot application for managing products in a catalog. The application allows users to perform CRUD operations on product data, including adding, updating, deleting, and searching products based on various criteria.

---

## *Features*
- *Add* a new product to the catalog.
- *Retrieve* all products or a specific product by its ID.
- *Update* an existing product by its ID.
- *Delete* a product from the catalog by its ID.
- *Search* products by brand, category, name (containing a keyword), and price range.

---

## *Technologies Used*
- *Backend*: Spring Boot, Spring Data JPA, Hibernate
- *Database*: MySQL
- *Build Tool*: Maven
- *Validation*: Bean Validation (Jakarta Annotations)
- *Logging*: SLF4J

---

## *Setup Instructions*

### *Prerequisites*
- Java 17 or above
- Maven 3.x
- MySQL Server (configured on localhost)

### *Steps to Run Locally*

1. *Clone the repository*:
   bash
   git clone https://github.com/your-username/catalog-management-system.git
   cd catalog-management-system
   
---

# **API Endpoints**

### **Product CRUD Operations**

| Method | Endpoint                         | Description                          | Request Body                              |
|--------|----------------------------------|--------------------------------------|------------------------------------------|
| POST   | `/product/add`                  | Add a new product                    | `ProductRequest` (JSON)                  |
| GET    | `/product/get/all`              | Get all products                     | N/A                                      |
| GET    | `/product/get/{id}`             | Get product by ID                    | N/A                                      |
| PUT    | `/product/update/{id}`          | Update product by ID                 | `ProductRequest` (JSON)                  |
| DELETE | `/product/delete`               | Delete product by ID                 | Query parameter: `id`                    |
| GET    | `/product/get/brand`            | Get products by brand                | Query parameter: `brand`                 |
| GET    | `/product/get/category`         | Get products by category             | Query parameter: `category`              |
| GET    | `/product/get/NameContaining`   | Get products by name containing keyword | Query parameter: `keyword`             |
| GET    | `/product/get/priceRange`       | Get products within a price range    | Query parameters: `min`, `max`           |

---

## **Request/Response Formats**

### **Request Format**
#### **ProductRequest**

When adding or updating a product, the API expects the following structure in the request body:

   ```json
   {
     "name": "Smartphone",
     "quantity": 10,
     "brand": "TechBrand",
     "category": "Electronics",
     "description": "A high-performance smartphone",
     "price": 699.99
   }
