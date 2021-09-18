package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    Product findByProductName(String productName);
    @Query("{Category.categoryName?:0}")
    List<Product> findByCategoryName(String categoryName);
    Product findById(long id);
    Product findByProductSequence(String sequence);
    List<Product> findAll();
}
