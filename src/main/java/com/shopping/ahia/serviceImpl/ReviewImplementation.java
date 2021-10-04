package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.models.userContent.AppUser;
import com.shopping.ahia.models.userContent.Review;
import com.shopping.ahia.repository.AppUserRepository;
import com.shopping.ahia.repository.ProductRepository;
import com.shopping.ahia.repository.ReviewRepository;
import com.shopping.ahia.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewImplementation implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Review saveReview(String productId, String userId, Review review)throws Exception{
       try{
           Product product = productRepository.findById(productId);
           AppUser appUser = appUserRepository.findById(userId);
           product.getReview().add(review);
           appUser.getReview().add(review);
           review.setProduct(product);
           review.setAppUser(appUser);
           Review review1 = reviewRepository.save(review);
           return review1;

       }catch(Exception ex){
            throw new Exception("Review was not saved");
       }
    }

    @Override
    public Review getReview(String reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public void deleteReview(String reviewId) {
        reviewRepository.delete(getReview(reviewId));
    }
}
