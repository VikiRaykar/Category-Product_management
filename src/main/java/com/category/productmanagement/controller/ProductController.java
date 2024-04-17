package com.category.productmanagement.controller;

import com.category.productmanagement.pojo.Product;
import com.category.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable Long id){
        return productService.updateProduct(product,id);
    }
    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }
}
