package com.shopping.ahia.service;

import com.shopping.ahia.models.productContent.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BrandService {
    Brand saveOrUpdate(Brand Brand) throws Exception;
    void deleteBrandById(long id) throws Exception;
    Brand findByBrandId(long id) throws Exception;
    List<Brand> findAllBrand();
    Brand findByBrandName(String BrandName) throws Exception;
    List<Brand> findProductByBrandName(String productName) throws Exception;
}
