package com.example.gym5b.models.routines;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RoutinesRespository extends MongoRepository<Routines, String > {

    @Query("{'name': ?0, 'description': ?1, 'type': ?2}")
    Routines addRoutine(String name, String description, String type);

    @Query("{'name': ?0}")
    Routines findRoutineByName(String name);

    @Query("[{ '$project': { 'id_routine': 1, 'name': 1, 'description': 1, 'type': 1 }}, { '$sort': { 'name': 1 } }]")
    Routines findAllRoutines();

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    Routines findRoutinesByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    Routines findRoutinesByDesc();

    @Query(value = "[{ '$sort': { 'type': -1 } }]")
    Routines findRoutinesByTypeDesc();

    @Query(value = "[{ '$sort': { 'type': 1 } }]")
    Routines findRoutinesByTypeAsc();

    @Query("{'name': ?0}")
    Routines updateRoutineByName(String name, String description, String type);

    @Query("{'name': ?0}")
    Routines deleteRoutineByName(String name);
}
