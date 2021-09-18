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

import javax.validation.Valid;
import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ErrorMapping errorMapping;

    @PostMapping("/{categoryIdentifier}")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product, @PathVariable String categoryIdentifier, BindingResult result)throws Exception{
        ResponseEntity<?> errorMap = errorMapping.ErrorMappingService(result);
        if(errorMap != null){
            return errorMap;
        }
        Product product1 = productService.saveOrUpdate(categoryIdentifier, product);
        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable long id) throws Exception {
        Product product1 = productService.findByProductId(id);
        return new ResponseEntity<Product>(product1, HttpStatus.OK);
    }
    @GetMapping("/{productName}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String productName) throws Exception {
        Product product1 = productService.findByProductName(productName);
        return new ResponseEntity<Product>(product1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/{categoryName}")
    public List<Product> getCategory(@PathVariable String categoryName) throws Exception {
        return productService.findProductByCategory(categoryName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id) throws Exception {
        productService.deleteProductById(id);
        return new ResponseEntity<String>("User with ID: " + id + " was deleted", HttpStatus.OK);
    }
}
