package com.category.productmanagement.service;

import com.category.productmanagement.pojo.Category;
import com.category.productmanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public Category addCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
       return categoryRepository.findById(id).get();
    }

    @Override
    public Category updateCategory(Category newCategory, Long id) {
        Category category=categoryRepository.findById(id).orElse(null);
        if(category!=null){
            category.setCategoryName(newCategory.getCategoryName());
            category.setActiveStatus(newCategory.getActiveStatus());
           return categoryRepository.save(category);
        } else{
            newCategory.setCategoryId(id);
            return categoryRepository.save(newCategory);
        }
    }

    @Override
    public String deleteCategoryById(Long id) {
         categoryRepository.deleteById(id);
         return "Category deleted successfully!";
    }
}
