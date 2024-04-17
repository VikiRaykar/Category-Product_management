package com.category.productmanagement.service;

import com.category.productmanagement.pojo.Category;

import java.util.List;

public interface CategoryService {
     List<Category> getAllCategories();
     Category addCategory(Category category);
     Category getCategoryById(Long id);
     Category updateCategory(Category category, Long id);
     String deleteCategoryById(Long id);
}
