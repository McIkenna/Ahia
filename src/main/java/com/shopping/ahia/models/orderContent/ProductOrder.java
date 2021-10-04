package com.shopping.ahia.models.cartItem;

import com.shopping.ahia.models.productContent.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class ProductOrder {
    @Id
    private String id;
    private int quantity;
    private double totalPrice;
    @DBRef
    private List<Product> product= new ArrayList<Product>(); //many to one with Product

}
