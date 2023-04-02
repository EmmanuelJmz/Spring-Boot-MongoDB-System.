package com.example.gym5b.models.products;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductsRepository extends MongoRepository<Products, String > {
    @Query("{'name': ?0, 'description': ?1, 'price': ?2, 'quantity': ?3}")
    Products addProduct(String name, String description, int price, int quantity);

    //findByName
    @Query("{'name': ?0}")
    Products findProductByName(String name);

    @Query("[{ '$project': { 'id_product': 1, 'name': 1, 'description': 1, 'price': 1, 'quantity': 1 }}, { '$sort': { 'name': 1 } }]")
    List<Products> findAllProducts();

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    List<Products> findProductsByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    List<Products> findProductsByDesc();

    @Query(value = "[{ '$sort': { 'quantity': -1 } }]")
    List<Products> findProductsByQuantityDesc();

    @Query(value = "[{ '$sort': { 'quantity': 1 } }]")
    List<Products> findProductsByQuantityAsc();

    @Query("{'name': ?0}")
    Products updateProductByName(String name, String description, int price, int quantity);
    @Query("{'name': ?0}")
    void deleteProductByName(String name);
}
