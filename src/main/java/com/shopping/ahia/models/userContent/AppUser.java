package com.shopping.ahia.models.userContent;

import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.orderContent.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    //private String authorities;
   // private String userImage;
    @DBRef
    private CustomerDetail customerDetail;//One to one with the User
   @DBRef
    private List<Review> review = new ArrayList<Review>() ; //one to many with cart*/
    @DBRef
    private List<ProductOrder> productOrders = new ArrayList<ProductOrder>();
}
