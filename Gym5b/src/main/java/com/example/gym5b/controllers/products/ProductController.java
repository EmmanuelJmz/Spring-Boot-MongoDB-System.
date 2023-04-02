package com.example.gym5b.controllers.products;

import com.example.gym5b.models.products.Products;
import com.example.gym5b.services.products.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gym")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductsService productsService;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Products addProduct(@RequestBody Products products){
        logger.info("Creando el producto: {}...", products.getName());
        return productsService.addProduct(products);
    }

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        logger.info("Obteniendo todos los productos...");
        return productsService.findAllProducts();
    }

    @GetMapping("/products/{name}")
    public Products findProductByName(@PathVariable String name){
        logger.info("Obteniendo el producto: {}...", name);
        return productsService.findProductByName(name);
    }

    @GetMapping("/productsDesc/")
    public List<Products> findProductsByDesc(){
        logger.info("Obteniendo los productos ordenados por nombre descendente...");
        return productsService.findProductsByDesc();
    }

    @GetMapping("/productsAsc/")
    public List<Products> findProductsByAsc(){
        logger.info("Obteniendo los productos ordenados por nombre ascendente...");
        return productsService.findProductsByAsc();
    }

    @GetMapping("/productsQuantityDesc/")
    public List<Products> findProductsByQuantityDesc(){
        logger.info("Obteniendo los productos ordenados por cantidad descendente...");
        return productsService.findProductsByQuantityDesc();
    }

    @GetMapping("/productsQuantityAsc/")
    public List<Products> findProductsByQuantityAsc(){
        logger.info("Obteniendo los productos ordenados por cantidad ascendente...");
        return productsService.findProductsByQuantityAsc();
    }

    @PutMapping("/products/{name}")
    public Products updateProduct(@RequestBody Products products){
        logger.info("Actualizando el producto: {}...", products.getName());
        return productsService.updateProduct(products);
    }

    @DeleteMapping("/products/{name}")
    public String deleteProduct(@PathVariable String name){
        logger.info("Eliminando el producto: {}...", name);
        return productsService.deleteProduct(name);
    }
}
