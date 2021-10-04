package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Category;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.repository.CategoryRepository;
import com.shopping.ahia.repository.ProductRepository;
import com.shopping.ahia.repository.ReviewRepository;
import com.shopping.ahia.service.CategoryService;
import com.shopping.ahia.service.ProductService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductImplementation implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public Product save(Product product, String categoryId,  MultipartFile[] files, MultipartFile file) throws Exception {
        try{

            Category category = categoryRepository.findById(categoryId);
            product.setCategoryId(categoryId);
            product.setMainImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
                for(MultipartFile extraFile : files){
                    product.getExtraImages().add(new Binary(BsonBinarySubType.BINARY, extraFile.getBytes()));
                  /*  if(count == 0) product.setExtraImage1(new Binary(BsonBinarySubType.BINARY, extraFile.getBytes()));
                    if(count == 1) product.setExtraImage1(new Binary(BsonBinarySubType.BINARY, extraFile.getBytes()));
                    if(count == 2) product.setExtraImage1(new Binary(BsonBinarySubType.BINARY, extraFile.getBytes()));
                    if(count == 3) product.setExtraImage1(new Binary(BsonBinarySubType.BINARY, extraFile.getBytes()));
                    count++;*/
                }

            product.getBrand().setBrandName(product.getBrand().getBrandName().toUpperCase());

            Product product1 = productRepository.save(product);
            category.getProducts().add(product1);
            categoryRepository.save(category);
          return product1;
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void deleteProductById(String id) throws Exception {
       productRepository.delete(findByProductId(id));
    }

    @Override
    public Product findByProductId(String id) throws Exception {
        try{

            return productRepository.findById(id);

        }catch (Exception e){
            throw new Exception("Product with ID " + id + " Does not exist");
        }
    }



    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findByProductName(String productName) throws Exception {
        try{

            return productRepository.findByProductName(productName);

        }catch(Exception ex){
            throw new Exception("product with Id "+ productName +" does not exist");
        }
    }

    @Override
    public List<Product> findProductByCategory(String categoryId) throws Exception {
        try{
            List<Product> products = productRepository.findByCategoryId(categoryId);
            return products;
        }catch(Exception ex){
            throw new Exception("product with Id "+ categoryId +" does not exist");
        }
    }

    @Override
    public List<Product> findByBrandName(String brandName) throws Exception {
        try{
            List<Product> products = productRepository.findByBrand_BrandName(brandName);
            return products;
        }catch(Exception ex){
            throw new Exception("product with Id "+ brandName +" does not exist");
        }
    }
}
