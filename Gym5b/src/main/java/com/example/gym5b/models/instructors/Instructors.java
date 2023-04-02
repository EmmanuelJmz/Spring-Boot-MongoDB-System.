package com.example.gym5b.models.instructors;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructors {
    @Id
    private String id_user;
    private String name;
    private String last_name;
    private int age;
    private String email;
    private String password;
}
