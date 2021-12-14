package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
    Category findById(String id);
    void deleteById(String id);
    List<Category> findAll();
}
