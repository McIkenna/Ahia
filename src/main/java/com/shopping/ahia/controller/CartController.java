package com.shopping.ahia.controller;

import com.shopping.ahia.errorMapping.ErrorMapping;
import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ErrorMapping errorMapping;

    @PostMapping("/{productId}")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Cart cart, String productId, BindingResult result)throws Exception{
        ResponseEntity<?> errorMap = errorMapping.ErrorMappingService(result);
        if(errorMap != null){
            return errorMap;
        }



        Cart cart1 = cartService.addToCart(cart, productId);
        return new ResponseEntity<Cart>(cart1, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public List<Cart> getAllCart(){
        return cartService.itemsInCart();
    }


    @DeleteMapping()
    public ResponseEntity<?> deleteAll(){
        cartService.clearCart();
        return new ResponseEntity<String>("Cart Item was deleted", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable String id) throws Exception {
        cartService.deleteCartItem(id);
        return new ResponseEntity<String>("User with ID: " + id + " was deleted", HttpStatus.OK);
    }
}
