package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.models.userContent.AppUser;
import com.shopping.ahia.repository.AppUserRepository;
import com.shopping.ahia.repository.CartRepository;
import com.shopping.ahia.repository.CategoryRepository;
import com.shopping.ahia.repository.ProductRepository;
import com.shopping.ahia.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartImplementation implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Cart addToCart(Cart cart, String productId) throws Exception {
        try{
           // AppUser user = appUserRepository.findById(userId);
            Product product = productRepository.findById(productId);
            //cart.setAppUser(user);
            cart.setCartImage(product.getMainImage());
            cart.setProduct(product);
            return cartRepository.save(cart);
        }catch(Exception ex){
            throw new Exception("Something went wrong");
        }
    }

    @Override
    public Cart listCartItems(AppUser user) {
        List<Cart> cartList = cartRepository.findAllByAppUserOrderByCreatedDateDesc(user);

        double totalCost = 0;
        for(Cart cartItems: cartList){
            totalCost +=(cartItems.getProduct().getPrice()*cartItems.getQuantity());
        }
        Cart cart = new Cart();
        cart.setTotalPrice(totalCost);
        return cart;

    }

    @Override
    public List<Cart> itemsInCart() {
        return cartRepository.findAll();
    }


    @Override
    public Cart CartItems() {
        List<Cart> cartList = cartRepository.findAll();
        double totalCost = 0;
        for(Cart cartItems: cartList){
            totalCost +=(cartItems.getProduct().getPrice()*cartItems.getQuantity());
        }
        Cart cart = new Cart();
        cart.setTotalPrice(totalCost);
        return cart;

    }

    @Override
    public void deleteCartItem(String cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public void clearCart() {
        cartRepository.deleteAll();
    }

    @Override
    public void deleteUserCartItem(AppUser user) {
        cartRepository.deleteByAppUser(user);
    }
}
