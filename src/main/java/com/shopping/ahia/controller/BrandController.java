package com.shopping.ahia.controller;

import com.shopping.ahia.errorMapping.ErrorMapping;
import com.shopping.ahia.models.productContent.Brand;
import com.shopping.ahia.service.BrandService;
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
@RequestMapping("/api/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    BrandService brandService;
    @Autowired
    ErrorMapping errorMapping;

    @PostMapping("")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Brand brand, BindingResult result)throws Exception{
        ResponseEntity<?> errorMap = errorMapping.ErrorMappingService(result);
        if(errorMap != null){
            return errorMap;
        }
        Brand brand1 = brandService.saveOrUpdate(brand);
        return new ResponseEntity<Brand>(brand1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable long id) throws Exception {
    Brand brand = brandService.findByBrandId(id);
    return new ResponseEntity<Brand>(brand, HttpStatus.OK);
    }
    @GetMapping("/{brandName}")
    public ResponseEntity<?> getBrandByName(@PathVariable String brandName) throws Exception {
        Brand brand1 = brandService.findByBrandName(brandName);
        return new ResponseEntity<Brand>(brand1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Brand> getAllBrand(){
        return brandService.findAllBrand();
    }

    @GetMapping("/{productName}")
    public List<Brand> getProducts(@PathVariable String productName) throws Exception {
        return brandService.findProductByBrandName(productName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable long id) throws Exception {
        brandService.deleteBrandById(id);
        return new ResponseEntity<String>("User with ID: " + id + " was deleted", HttpStatus.OK);
    }
}
