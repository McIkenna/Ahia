package com.shopping.ahia.service;

import com.shopping.ahia.models.productContent.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductService {
    Product saveOrUpdate(String categoryIdentifier, Product product) throws Exception;

    void deleteProductById(long id) throws Exception;

    Product findByProductId(long id) throws Exception;

    List<Product> findAllProduct();

    Product findByProductName(String productName) throws Exception;

    List<Product> findProductByCategory(String categoryName) throws Exception;
}
