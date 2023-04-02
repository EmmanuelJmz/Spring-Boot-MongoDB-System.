package com.example.gym5b.models.routines;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "routines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Routines  {
    @Id
    private String id_routine;
    private String name;
    private String description;
    private String type;

}
