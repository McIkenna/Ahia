package com.shopping.ahia.models.cartContent;

import com.shopping.ahia.models.common.PaymentMethod;
import com.shopping.ahia.models.common.Status;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.models.userContent.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    private String id;
    private String productId;
    private Date createdDate;
    private Status orderStatus;
    private Binary cartImage;
    private String productName;
    private int quantity;
    private double price;
   // @DBRef
   // private AppUser appUser;
//    //private PaymentMethod paymentMethod;
//   @DBRef
//    private List<Product> product = new ArrayList<>(); //one to many of product

    public Cart(Date createdDate) {
        this.createdDate = new Date();
    }
}
