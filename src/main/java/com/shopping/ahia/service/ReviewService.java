package com.shopping.ahia.service;

import com.shopping.ahia.models.userContent.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReviewService {
    List<Review> findAllReview();
    Review saveReview(String productId, String userId, Review review)throws  Exception;
    Review getReview(String reviewId);
    void deleteReview(String reviewId);
}
