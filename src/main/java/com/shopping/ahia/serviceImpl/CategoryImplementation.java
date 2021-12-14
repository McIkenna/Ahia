package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Category;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.repository.CategoryRepository;
import com.shopping.ahia.repository.ProductRepository;
import com.shopping.ahia.service.CategoryService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class CategoryImplementation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MongoOperations mongoOperations;
    @Autowired
    ProductRepository productRepository;


/*
    @Override
    public Category save(MultipartFile file, Category category) throws Exception {
        try{
            category.setCategoryImage(
                    new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            return categoryRepository.save(category);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    } */

    @Override
    public Category save(MultipartFile file, Category category) throws Exception {
        try{

            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(category.getId()));
            Category category1 = mongoOperations.findOne(query, Category.class);
            if(category1 == null){
                category.setCategoryImage(new Binary(BsonBinarySubType.MD5, file.getBytes()));
                return categoryRepository.save(category);
            }else{
                category1.setCategoryName(category.getCategoryName());
                category1.setCategoryDescription(category.getCategoryDescription());
                category1.setCategoryImage(new Binary(BsonBinarySubType.MD5, file.getBytes()));
                return categoryRepository.save(category1);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

/*
    @Override
    public Category update(Category category) throws Exception {

        try{
            return categoryRepository.save(category);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }*/

    @Override
    public void deleteCategoryById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categoryId").is(id));
        List<Product> product1= mongoOperations.find(query, Product.class);
        productRepository.deleteAll(product1);
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(String id) throws Exception {

       Category category = categoryRepository.findById(id);
       if(category == null){
           throw new Exception("Category with id " + id + " does not exist");
       }
     /* Query query = new Query(Criteria.where("id").is(new ObjectId(id)));
        Category category = mongoTemplate.findOne(query, Category.class);
*/
        return category;

    }

    @Override
    public Map<String, Object> getAllCategoryInPage(int pageNo, int pageSize, String sortBy){
        Map<String, Object> response = new HashMap<String, Object>();
        Sort sort = Sort.by(sortBy);
        Pageable page = PageRequest.of(pageNo, pageSize, sort);
        Page<Category> categoryPage = categoryRepository.findAll(page);
        response.put("data", categoryPage.getContent());
        response.put("Total No of page", categoryPage.getTotalPages());
        response.put("Total No of elements", categoryPage.getTotalElements());
        response.put("Current Page No", categoryPage.getNumber());

        return response;
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

    public boolean categoryContains(String categoryName) throws Exception {
        if(categoryName.contains("Alaba")){
            throw new Exception("Category contains Alaba");
        }
        return false;
    }
}
