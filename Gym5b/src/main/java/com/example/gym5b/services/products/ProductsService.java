package com.example.gym5b.services.products;

import com.example.gym5b.models.products.Products;
import com.example.gym5b.models.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    //CRUD OPERATIONS FOR PRODUCTS <3 <3 <3

    //CREATE
    public Products addProduct(Products products){
        products.setId_product(UUID.randomUUID().toString().split("-")[0]);
        return productsRepository.addProduct(products.getName(), products.getDescription(), products.getPrice(), products.getQuantity());
    }

    //READ
    public Products findProductByName(String name){
        return productsRepository.findProductByName(name);
    }
    public List<Products> findAllProducts(){
        return productsRepository.findAllProducts();
    }

    public List<Products> findProductsByAsc(){
        return productsRepository.findProductsByAsc();
    }

    public List<Products> findProductsByDesc(){
        return productsRepository.findProductsByDesc();
    }

    public List<Products> findProductsByQuantityAsc(){
        return productsRepository.findProductsByQuantityAsc();
    }

    public List<Products> findProductsByQuantityDesc(){
        return productsRepository.findProductsByQuantityDesc();
    }

    //UPDATE
    //Actualiza el producto por el nombre del producto y los datos del producto que se le pasan como parametro
    //El nombre del producto que se le pasa como parametro es el que se va a actualizar

    public Products updateProduct(Products productsUpdate){
        Products existingProducts = productsRepository.findProductByName(productsUpdate.getName());
        existingProducts.setName(productsUpdate.getName());
        existingProducts.setDescription(productsUpdate.getDescription());
        existingProducts.setPrice(productsUpdate.getPrice());
        existingProducts.setQuantity(productsUpdate.getQuantity());
        return productsRepository.updateProductByName(
                existingProducts.getName(),
                existingProducts.getDescription(),
                existingProducts.getPrice(),
                existingProducts.getQuantity());
    }

    //DELETE
    public String deleteProduct(String name){
        productsRepository.deleteProductByName(name);
        return name + "Producto eliminado :)";
    }
}
