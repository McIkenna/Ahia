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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<?> saveCategory(@Valid @ModelAttribute Category category, MultipartFile file, BindingResult result)throws Exception{
        ResponseEntity<?> errorMap = errorMapping.ErrorMappingService(result);
        if(errorMap != null){
            return errorMap;
        }
        Category category1 = categoryService.save(file, category);
        return new ResponseEntity<Category>(category1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable String id) throws Exception {
        return categoryService.findById(id);
    }


    /*
    @GetMapping("/{categoryName}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String categoryName){
        Category Cat1 = categoryService.findByCategoryName(categoryName);
        return new ResponseEntity<Category>(Cat1, HttpStatus.OK);
    }*/

    @GetMapping("/all")
    public List<Category> getAllCategory(){
        return categoryService.findAllCategory();
    }


    @GetMapping("/page")
    public Map<String, Object> getAllCategoryInPage(@RequestParam(name="pageNo", defaultValue = "0") int pageNo,
                                                    @RequestParam(name="pageSize", defaultValue = "2") int pageSize,
                                                    @RequestParam(name="sortBy", defaultValue = "id") String sortBy){
        return categoryService.getAllCategoryInPage(pageNo, pageSize, sortBy);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<String>("User with ID: " + id + " was deleted", HttpStatus.OK);
    }
}
