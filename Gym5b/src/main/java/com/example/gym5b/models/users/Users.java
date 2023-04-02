package com.example.gym5b.models.users;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private String id_user;
    private String name;
    private String last_name;
    private int age;
    private String email;
    private String password;

    public Users(String name, String lastName, int age, String email, String password) {
    }
}
