package com.example.gym5b.models.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<Users, String > {
    List<Users> findUserByName(String name);

    @Query("{ 'email' : ?0 }")
    List<Users> findUserByEmail(String email);
}
