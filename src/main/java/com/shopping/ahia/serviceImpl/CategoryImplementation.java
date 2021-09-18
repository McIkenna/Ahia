package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Category;
import com.shopping.ahia.models.productContent.ProductLog;
import com.shopping.ahia.repository.CategoryRepository;
import com.shopping.ahia.repository.ProductLogRepository;
import com.shopping.ahia.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryImplementation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductLogRepository productLogRepository;

    @Override
    public Category saveOrUpdate(Category category) throws Exception {
        UUID newId = UUID.randomUUID();
        Integer catSequence = category.getCategoryIdentifier();
        catSequence++;
        try{
            Category category1 = new Category(category.getId(), category.getCategoryName(), category.getCategoryIdentifier(), category.getCategoryDescription(), category.getProductLog());
            category1.setCategoryIdentifier(catSequence);
            if(category1.getId() == null){
                    ProductLog productLog = new ProductLog();
                    category1.setProductLog(productLog);
                    productLog.setCategory(category1);


                   // productLog.setCategoryIdentifier(category1.getCategoryIdentifier());
                }if(category1.getId() != null){
             //   category1.setProductLog(productLogRepository.findByCategoryIdentifier(category1.getCategoryIdentifier()));
            }
                return categoryRepository.save(category);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.delete(findByCategoryId(id));
    }

    @Override
    public Category findByCategoryId(long id) {
        Category category = categoryRepository.findById(id);
        return category;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByCategoryName(String categoryName) {
        Category preCategory = categoryRepository.findByCategoryName(categoryName);
        return preCategory;
    }
}
