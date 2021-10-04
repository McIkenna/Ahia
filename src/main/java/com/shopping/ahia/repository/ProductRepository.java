package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    Product findByProductName(String productName);
    List<Product> findByCategoryId(String categoryId);
    Product findById(String id);
    List<Product> findAll();
    List<Product> findByBrand_BrandName(String brandName);
}
