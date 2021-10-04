package com.shopping.ahia.repository;

import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.userContent.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser, Long> {
    List<AppUser> findAll();
    AppUser findByEmail(String email);
    AppUser findById(String id);
}
