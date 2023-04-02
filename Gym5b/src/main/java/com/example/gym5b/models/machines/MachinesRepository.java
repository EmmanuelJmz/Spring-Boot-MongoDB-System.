package com.example.gym5b.models.machines;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MachinesRepository extends MongoRepository<Machines, String > {

    @Query("{'name': ?0, 'description': ?1, 'quantity': ?2}")
    Machines addMachine(String name, String description, int quantity);

    @Query("{'name': ?0}")
    Machines findMachineByName(String name);

    @Query("[{ '$project': { 'id_machine': 1, 'name': 1, 'description': 1, 'quantity': 1 }}, { '$sort': { 'name': 1 } }]")
    List<Machines> findAllMachines();

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    List<Machines> findMachinesByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    List<Machines> findMachinesByDesc();

    @Query(value = "[{ '$sort': { 'quantity': -1 } }]")
    List<Machines> findMachinesByQuantityDesc();

    @Query(value = "[{ '$sort': { 'quantity': 1 } }]")
    List<Machines> findMachinesByQuantityAsc();

    @Query("{'name': ?0}")
    Machines updateMachineByName(String name, String description, int quantity);

    @Query("{'name': ?0}")
    Machines deleteMachineByName(String name);
}
