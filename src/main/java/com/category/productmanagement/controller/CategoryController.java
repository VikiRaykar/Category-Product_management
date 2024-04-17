package com.category.productmanagement.controller;

import com.category.productmanagement.pojo.Category;
import com.category.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/categories")
    public List<Category> getAllCategories(){
      return categoryService.getAllCategories();
   }
   @PostMapping("/categories")
   public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
   }
   @GetMapping("/categories/{id}")
   public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
   }
   @PutMapping("/categories/{id}")
   public Category updateCategory(@RequestBody Category newCategory,@PathVariable Long id){
        return categoryService.updateCategory(newCategory,id);
   }
   @DeleteMapping("/categories/{id}")
   public String deleteCategoryById(@PathVariable Long id){
        return categoryService.deleteCategoryById(id);
   }
}
