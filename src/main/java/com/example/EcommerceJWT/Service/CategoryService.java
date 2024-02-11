package com.example.EcommerceJWT.Service;


import com.example.EcommerceJWT.Model.Category;
import com.example.EcommerceJWT.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepositoryObject;

    public Category saveCategory(Category c){
        return categoryRepositoryObject.save(c);
    }

    public List<Category> saveAllCategories(List<Category> c){
        return categoryRepositoryObject.saveAll(c);
    }

    public Category updateCategory(Category c){
        return categoryRepositoryObject.saveAndFlush(c);
    }

    public Optional<Category> findCategoryById(int id){
        return categoryRepositoryObject.findById(id);
    }

    public void deleteCategoryById(int id){
        categoryRepositoryObject.deleteById(id);
    }

    public boolean existCategoryById(int id){
        return categoryRepositoryObject.existsById(id);
    }

    public List<Category> findAllCategories(){
        return categoryRepositoryObject.findAll();
    }


}
