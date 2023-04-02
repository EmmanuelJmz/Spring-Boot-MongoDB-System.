package com.example.gym5b.models.exersices;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "exercises")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercises {
    @Id
    private String id_exercise;
    private String name;
    private String description;
    private String type;
}
