package com.shopping.ahia.service;

import com.shopping.ahia.models.productContent.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Component
public interface ProductService {
    Product save(Product product, String categoryId, MultipartFile[] files, MultipartFile file) throws Exception;

    void deleteProductById(String id) throws Exception;

    Product findByProductId(String id) throws Exception;
    List<Product> findAllProduct();
    Product findByProductName(String productName) throws Exception;

    List<Product> findProductByCategory(String categoryId) throws Exception;
    List<Product> findByBrand(String brand) throws Exception;
}
