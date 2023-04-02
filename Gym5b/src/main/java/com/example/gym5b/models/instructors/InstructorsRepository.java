package com.example.gym5b.models.instructors;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface InstructorsRepository extends MongoRepository<Instructors, String > {

    @Query("{'name': ?0, 'last_name': ?1, 'age': ?2, 'email': ?3, 'password': ?4}")
    Instructors addInstructor(String name, String last_name, int age, String email, String password);

    @Query("{'name': ?0}")
    Instructors findInstructorByName(String name);

    @Query("[{ '$project': { 'id_instructor': 1, 'name': 1, 'last_name': 1, 'age': 1, 'email': 1, 'password': 1 }}, { '$sort': { 'name': 1 } }]")
    List<Instructors> findAllInstructors();

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    List<Instructors> findInstructorsByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    List<Instructors> findInstructorsByDesc();

    @Query(value = "[{ '$sort': { 'age': -1 } }]")
    List<Instructors> findInstructorsByAgeDesc();

    @Query(value = "[{ '$sort': { 'age': 1 } }]")
    List<Instructors> findInstructorsByAgeAsc();

    @Query("{'name': ?0}")
    Instructors updateInstructorByName(String name, String last_name, int age, String email, String password, String existingInstructorsPassword);

    @Query("{'name': ?0}")
    Instructors deleteInstructorByName(String name);    
}
