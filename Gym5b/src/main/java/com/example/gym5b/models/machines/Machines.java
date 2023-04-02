package com.example.gym5b.models.machines;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "machines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machines {
    @Id
    private String id_machine;
    private String name;
    private String description;
    private int quantity;
}
