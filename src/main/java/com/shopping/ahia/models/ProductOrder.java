package com.shopping.ahia.models;

import com.shopping.ahia.models.productContent.Product;

public class ProductOrder {
    private int quantity;
    private double totalPrice;
    private Product product; //many to one with Product

}
