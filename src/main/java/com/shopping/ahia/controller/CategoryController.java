package com.shopping.ahia.controller;

import com.shopping.ahia.errorMapping.ErrorMapping;
import com.shopping.ahia.models.productContent.Category;
import com.shopping.ahia.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ErrorMapping errorMapping;

    @PostMapping("")
    public ResponseEntity<?> saveCategory(@Valid @RequestBody Category category, BindingResult result)throws Exception{
        ResponseEntity<?> errorMap = errorMapping.ErrorMappingService(result);
        if(errorMap != null){
            return errorMap;
        }
        Category category1 = categoryService.saveOrUpdate(category);
        return new ResponseEntity<Category>(category1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable long id){
        Category Cat1 = categoryService.findByCategoryId(id);
        return new ResponseEntity<Category>(Cat1, HttpStatus.OK);
    }
    @GetMapping("/{categoryName}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String categoryName){
        Category Cat1 = categoryService.findByCategoryName(categoryName);
        return new ResponseEntity<Category>(Cat1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Category> getAllCategory(){
        return categoryService.findAllCategory();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<String>("User with ID: " + id + " was deleted", HttpStatus.OK);
    }
}
