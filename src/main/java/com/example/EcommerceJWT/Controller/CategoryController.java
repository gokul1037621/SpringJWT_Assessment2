package com.example.EcommerceJWT.Controller;

import com.example.EcommerceJWT.Model.Category;
import com.example.EcommerceJWT.Service.CategoryService;
import com.example.EcommerceJWT.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecommerceJWT/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Category save(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PostMapping("/addall")
    public List<Category> saveAll(@RequestBody List<Category> allCategories){
        return categoryService.saveAllCategories(allCategories);
    }

    @GetMapping("/findbyid/{id}")
    public void findById(@PathVariable(name = "id") int id){
        if(categoryService.existCategoryById(id)){
            System.out.println(categoryService.findCategoryById(id));
        }else{
            System.out.println("Product is not present");
        }
    }
    @GetMapping("/getall")
    public List<Category> findall(){
        return categoryService.findAllCategories();
    }

    @DeleteMapping("/deletebyid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") int id){
        try {
            boolean categoryExists = categoryService.existCategoryById(id);
            if (categoryExists){
                categoryService.deleteCategoryById(id);
                System.out.println("Category id "+id+" successfully deleted");
            }else{
                System.out.println("Category does not exist");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @PostMapping("/updateCategory")
    public Category update(@RequestBody Category category){
        Category newCategory = category;
        System.out.println("Id of new product is " + newCategory.getCategoryId());
        if(categoryService.existCategoryById(newCategory.getCategoryId())){
            Category updatedCategory = categoryService.updateCategory(category);
            return updatedCategory;
        }
        System.out.println("Product does not exists");
        return null;
    }
}