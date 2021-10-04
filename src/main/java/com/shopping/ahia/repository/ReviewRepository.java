package com.shopping.ahia.repository;

import com.shopping.ahia.models.userContent.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, Long> {
    Review findById(String id);
}
