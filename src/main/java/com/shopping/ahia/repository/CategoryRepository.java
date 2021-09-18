package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CategoryRepository extends MongoRepository<Category, Long> {

    Category findByCategoryName(String categoryName);
    Category findById(long id);
    List<Category> findAll();
}
