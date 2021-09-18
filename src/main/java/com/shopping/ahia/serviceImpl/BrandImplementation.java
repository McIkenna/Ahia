package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Brand;
import com.shopping.ahia.repository.BrandRepository;
import com.shopping.ahia.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandImplementation implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Override
    public Brand saveOrUpdate(Brand Brand) throws Exception {

        try{
                return brandRepository.save(Brand);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteBrandById(long id) throws Exception {
        brandRepository.delete(findByBrandId(id));
    }

    @Override
    public Brand findByBrandId(long id) throws Exception {
        try{

            Brand brand = brandRepository.findById(id);
            return brand;
        }catch(Exception ex){
            throw new Exception("product with Id "+id+" does not exist");
        }
    }

    @Override
    public List<Brand> findAllBrand() {
      return brandRepository.findAll();
    }

    @Override
    public Brand findByBrandName(String brandName) throws Exception {
        try{

            Brand brand = brandRepository.findByBrandName(brandName);
            return brand;
        }catch(Exception ex){
            throw new Exception("Brand with Id "+brandName+" does not exist");
        }
    }

    @Override
    public List<Brand> findProductByBrandName(String brandName) throws Exception {
        try{

            return brandRepository.findByProductName(brandName);

        }catch(Exception ex){
            throw new Exception("product with Id "+ brandName +" does not exist");
        }
    }
}
