package com.shopping.ahia.repository;

import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.userContent.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart, Long> {
    //List<Cart> findAllByAppUserOrderByCreatedDateDesc(AppUser user);
    //List<Cart> deleteByAppUser(AppUser user);
    Cart findById(String id);
    Cart findByProductId(String id);
    List<Cart> findAll();
    void deleteById(String id);

}
