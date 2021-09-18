package com.shopping.ahia.models;

import java.util.Date;
import java.util.List;

public class Cart {
    private Date placedDate;
    private Status orderStatus;
    private double totalPrice;
    private PaymentMethod paymentMethod;
    private List<ProductOrder> productOrder; //one to many of product
}
