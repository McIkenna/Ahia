package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.WishList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends MongoRepository<WishList, Long> {
    WishList findByProduct_Id(String productId);
}
