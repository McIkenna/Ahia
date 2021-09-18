package com.shopping.ahia.service;

import com.shopping.ahia.models.productContent.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {
    Category saveOrUpdate(Category category) throws Exception;
    void deleteCategoryById(long id);
    Category findByCategoryId(long id);
    List<Category> findAllCategory();
    Category findByCategoryName(String categoryName);

}
