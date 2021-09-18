package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends MongoRepository<Brand, Long> {
    Brand findByBrandName(String BrandName);
    @Query("{Product.productName?:0}")
    List<Brand> findByProductName(String productName);
    Brand findById(long id);
    List<Brand> findAll();
}
