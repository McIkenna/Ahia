package com.shopping.ahia.controller;

import com.shopping.ahia.errorMapping.ErrorMapping;
import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.productContent.WishList;
import com.shopping.ahia.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/api/wish")
@CrossOrigin
public class WishListController {
    @Autowired
    WishListService wishListService;
    @Autowired
    ErrorMapping errorMapping;

    @PostMapping("/{productId}")
    public ResponseEntity<?> saveWishes(@Valid @PathVariable String productId)throws Exception{
        WishList wish = wishListService.saveWishes(productId);
        return new ResponseEntity<WishList>(wish, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<WishList> getAllWishes(){
        return wishListService.findAll();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteWish(@PathVariable String productId) throws Exception {
        wishListService.removeFromWishList(productId);
        return new ResponseEntity<String>("Wish Item with ID: " + productId + " was deleted", HttpStatus.OK);
    }

}
