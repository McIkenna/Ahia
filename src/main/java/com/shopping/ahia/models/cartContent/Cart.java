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

import java.util.Date;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    private String id;
    private Date createdDate;
    private Status orderStatus;
    private Binary cartImage;
    private int quantity;
    private double totalPrice;
    @DBRef
    private AppUser appUser;
    private PaymentMethod paymentMethod;
    @DBRef
    private Product product; //one to many of product

    public Cart(Date createdDate) {
        this.createdDate = new Date();
    }
}
