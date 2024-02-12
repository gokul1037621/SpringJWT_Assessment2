package com.example.EcommerceJWT.Service;


import com.example.EcommerceJWT.Model.Category;
import com.example.EcommerceJWT.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    /*
    category service class to define the functions that will be invoked by the controller during
    run time. controller calls the service class as and when required. dependency injection is done
    using autowired to use the repository object within the application context.
    th object uses pre built functions within JPA to perform db related tasks such as save, delete and
    search
     */
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
