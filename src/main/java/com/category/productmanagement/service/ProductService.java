package com.category.productmanagement.service;

import com.category.productmanagement.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts(Integer pageNumber,Integer pageSize);
    Product addProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Product product,Long id);
    String deleteProductById(Long id);
}
