package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.models.productContent.WishList;
import com.shopping.ahia.repository.ProductRepository;
import com.shopping.ahia.repository.WishListRepository;
import com.shopping.ahia.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListImplementation implements WishListService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WishListRepository wishListRepository;

    WishList myWishes = new WishList();

    @Override
    public WishList saveWishes(String productId) throws Exception{
        try{
            Product prod = productRepository.findById(productId);
            myWishes.getProduct().add(prod);
            return wishListRepository.save(myWishes);
        }catch (Exception ex){
            throw new Exception("Product not available");
        }
    }

    @Override
    public List<WishList> findAll() {
        return wishListRepository.findAll();
    }

    @Override
    public void removeFromWishList(String productId) throws Exception {

        Product product = productRepository.findById(productId);
        if(product == null){
            throw new Exception("Product does not exist");
        }
        myWishes.getProduct().remove(product);

    }
}
