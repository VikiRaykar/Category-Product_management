package com.category.productmanagement.service;

import com.category.productmanagement.pojo.Product;
import com.category.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product newProduct, Long id) {
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null){
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setActiveStatus(newProduct.getActiveStatus());
            product.setCategory(newProduct.getCategory()==null?product.getCategory()
                    :newProduct.getCategory());
            return productRepository.save(product);
        } else {
            newProduct.setProductId(id);
            return productRepository.save(newProduct);
        }
    }

    @Override
    public String deleteProductById(Long id) {
        productRepository.deleteById(id);
        return "Product Deleted Successfully";
    }
}
