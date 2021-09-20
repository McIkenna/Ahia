package com.shopping.ahia.service;

import com.shopping.ahia.models.productContent.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public interface CategoryService {
    Category update(Category category) throws Exception;
    Category save(Category category) throws Exception;
    void deleteCategoryById(String id);
    Optional<Category> findById(String id);
    Optional<Category> findByCategoryIdentifier(String id);
    List<Category> findAllCategory();
    Category findByCategoryName(String categoryName);
    Map<String, Object> getAllCategoryInPage(int pageNo, int pageSize, String sort);

}
