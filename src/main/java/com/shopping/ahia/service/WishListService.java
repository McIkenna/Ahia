package com.shopping.ahia.service;

import com.shopping.ahia.models.productContent.WishList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WishListService {
    WishList saveWishes(String productId) throws Exception;
    List<WishList> findAll();
    void removeFromWishList(String productId) throws Exception;
}

