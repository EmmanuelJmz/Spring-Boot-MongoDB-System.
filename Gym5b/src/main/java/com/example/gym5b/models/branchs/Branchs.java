package com.example.gym5b.models.branchs;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "branchs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branchs {
    @Id
    private String id_branch;
    private String name;
    private String address;
    private String phone;
}
