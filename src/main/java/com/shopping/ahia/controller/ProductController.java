package com.shopping.ahia.controller;

import com.shopping.ahia.errorMapping.ErrorMapping;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@SpringBootApplication
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ErrorMapping errorMapping;

    Logger logger;

    @PostMapping("/{categoryId}")
    public ResponseEntity<?> saveProduct(@Valid @ModelAttribute Product product, MultipartFile[] files, MultipartFile file, @PathVariable String categoryId, BindingResult result)throws Exception{
        ResponseEntity<?> errorMap = errorMapping.ErrorMappingService(result);
        if(errorMap != null){
            return errorMap;
        }



        Product product1 = productService.save(product, categoryId, files, file);
        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
    }

    @GetMapping("prod/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable String id) throws Exception {
        Product product1 = productService.findByProductId(id);
        return new ResponseEntity<Product>(product1, HttpStatus.OK);
    }
    @GetMapping("prods/{categoryId}")
    public List<Product> getCategoryByName(@PathVariable String categoryId) throws Exception {
        return productService.findProductByCategory(categoryId);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("cat/{categoryName}")
    public List<Product> getCategory(@PathVariable String categoryName) throws Exception {
        return productService.findProductByCategory(categoryName);
    }

    @GetMapping("brand/{brandName}")
    public List<Product> getBrandName(@PathVariable String brandName) throws Exception {
        return productService.findByBrandName(brandName.toUpperCase());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id) throws Exception {
        productService.deleteProductById(id);
        return new ResponseEntity<String>("User with ID: " + id + " was deleted", HttpStatus.OK);
    }
}
