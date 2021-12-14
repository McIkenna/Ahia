package com.shopping.ahia.service;

import com.shopping.ahia.models.productContent.Category;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public interface CategoryService {
    //Category update(Category category) throws Exception;
    Category save(MultipartFile file, Category category) throws Exception;
    void deleteCategoryById(String id);
    Category findById(String id) throws Exception;
    List<Category> findAllCategory();
    Category findByCategoryName(String categoryName);
    Map<String, Object> getAllCategoryInPage(int pageNo, int pageSize, String sort);

}
