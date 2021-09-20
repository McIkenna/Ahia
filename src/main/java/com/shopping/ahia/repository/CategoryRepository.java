package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends MongoRepository<Category, String> {


    Category findByCategoryName(String categoryName);

    Optional<Category> findById(String id);
    Optional<Category> findByCategoryIdentifier(String id);
    List<Category> findAll();
}
