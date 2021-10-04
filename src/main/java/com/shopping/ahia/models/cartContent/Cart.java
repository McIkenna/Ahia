package com.shopping.ahia.models.cartItem;

import com.shopping.ahia.models.userContent.AppUser;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Cart {
    @Id
    private String id;
    private Date placedDate;
    private Status orderStatus;
    private double totalPrice;
    @DBRef
    private AppUser appUser;
    private PaymentMethod paymentMethod;
    @DBRef
    private List<ProductOrder> productOrder; //one to many of product
}
