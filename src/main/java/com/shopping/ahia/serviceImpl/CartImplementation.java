package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.models.userContent.AppUser;
import com.shopping.ahia.repository.AppUserRepository;
import com.shopping.ahia.repository.CartRepository;
import com.shopping.ahia.repository.CategoryRepository;
import com.shopping.ahia.repository.ProductRepository;
import com.shopping.ahia.service.CartService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
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
    ProductRepository productRepository;

    @Override
    public Cart addToCart(Cart cart) throws Exception {
        try{
            int qty = 0;
           // AppUser user = appUserRepository.findById(userId);
//
//            Product product = productRepository.findById(productId);
            //cart.setAppUser(user);
//            cart.setProductId(product.getId());
//            cart.setQuantity(cart.getQuantity()+1);
//            cart.setCumPrice(cart.getCumPrice() + product.getPrice());
//            cart.setCartImage(product.getMainImage());
//            cart.getProduct().add(product);
            Cart cart1 = cartRepository.findById(cart.getId());
            Product product = productRepository.findById(cart.getId());
            cart.setCartImage(product.getMainImage());
            if(cart1 == null){
                cart.setQuantity(1);
                return cartRepository.save(cart);
            }
            cart.setQuantity(cart1.getQuantity()+1);
            return cartRepository.save(cart);
        }catch(Exception ex){
            throw new Exception("Something went wrong");
        }
    }

/*    @Override
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
*/
    @Override
    public List<Cart> itemsInCart() {
        return cartRepository.findAll();
    }


    @Override
    public Cart CartItems() {
        List<Cart> cartList = cartRepository.findAll();
        Cart cart = new Cart();
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
    public Cart findCartById(String id) throws Exception {
        Cart cart1 = cartRepository.findById(id);
        if(cart1 == null){
           throw new Exception("Item not available in cart");
        }
        return cart1;
    }

//    @Override
//    public void deleteUserCartItem(AppUser user) {
//        cartRepository.deleteByAppUser(user);
//    }
}
