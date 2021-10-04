package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Category;
import com.shopping.ahia.repository.CategoryRepository;
import com.shopping.ahia.service.CategoryService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
            category.setCategoryImage(
                    new Binary(BsonBinarySubType.MD5, file.getBytes()));
            return categoryRepository.save(category);
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
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(String id) {
       Category category = categoryRepository.findById(id);
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
}
