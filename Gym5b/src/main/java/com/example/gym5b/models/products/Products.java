package com.example.gym5b.models.products;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    private String id_product;
    private String name;
    private String description;
    private int price;
    private int quantity;
}
