package com.example.gym5b.models.branchs;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BranchsRepository extends MongoRepository<Branchs, String > {

    @Query("{'name': ?0, 'address': ?1, 'phone': ?2}")
    Branchs addBranch(String name, String address, String phone);

    @Query("{'name': ?0}")
    Branchs findBranchByName(String name);

    @Query("[{ '$project': { 'id_branch': 1, 'name': 1, 'address': 1, 'phone': 1 }}, { '$sort': { 'name': 1 } }]")
    Branchs findAllBranchs();

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    Branchs findBranchsByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    Branchs findBranchsByDesc();

    @Query("{ 'name': ?0 }")
    Branchs updateBranchByName(String name, String address, String phone);

    @Query("{'name': ?0}")
    Branchs deleteBranchByName(String name);
}
