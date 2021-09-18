package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.models.productContent.ProductLog;
import com.shopping.ahia.repository.CategoryRepository;
import com.shopping.ahia.repository.ProductLogRepository;
import com.shopping.ahia.repository.ProductRepository;
import com.shopping.ahia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductImplementation implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductLogRepository productLogRepository;
    @Override
    public Product saveOrUpdate(String categoryIdentifier,  Product product) throws Exception {

        UUID newId = UUID.randomUUID();
        try{
            product.setId(newId.toString());
            ProductLog productLog = productLogRepository.findByCategoryIdentifier(categoryIdentifier);
            product.setProductLog(productLog);
            Integer ProductLogSequence = productLog.getProductSequence();
            ProductLogSequence++;
            productLog.setProductSequence(ProductLogSequence);
            product.setProductSequence(product.getCategoryIdentifier()+ "-"+ ProductLogSequence);
            product.setCategoryIdentifier(categoryIdentifier);
            return productRepository.save(product);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @Override
    public void deleteProductById(long id) throws Exception {
            productRepository.delete(findByProductId(id));

    }

    @Override
    public Product findByProductId(long id) throws Exception {
        try{

            Product product = productRepository.findById(id);
            return product;
        }catch(Exception ex){
            throw new Exception("product with Id "+id+" does not exist");
        }
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findByProductName(String productName) throws Exception {
        try{

            Product product = productRepository.findByProductName(productName);
            return product;
        }catch(Exception ex){
            throw new Exception("product with Id "+ productName +" does not exist");
        }
    }

    @Override
    public List<Product> findProductByCategory(String categoryName) throws Exception {
        try{

            return productRepository.findByCategoryName(categoryName);

        }catch(Exception ex){
            throw new Exception("product with Id "+ categoryName +" does not exist");
        }
    }
}
