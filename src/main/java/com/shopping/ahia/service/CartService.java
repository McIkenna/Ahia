package com.shopping.ahia.service;

import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.models.userContent.AppUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartService {
    Cart addToCart(Cart cart, String productId)throws Exception;
    Cart CartItems();
    List<Cart> itemsInCart();
    Cart listCartItems(AppUser user);
    void deleteCartItem(String cartId);
    void clearCart();
    void deleteUserCartItem(AppUser user);
}
