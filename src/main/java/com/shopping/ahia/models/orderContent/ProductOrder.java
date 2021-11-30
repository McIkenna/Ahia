package com.shopping.ahia.models.orderContent;

import com.shopping.ahia.models.common.PaymentMethod;
import com.shopping.ahia.models.common.Status;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.models.userContent.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductOrder {
    @Id
    private String id;
    private int totalQuantity = 0;
    private double totalPrice = 0.0;
    private double shippingPrice;
    private Date createdDate;
    private PaymentMethod paymentMethod;
    private Status status;
    private double taxPrice;
    private Date paidAt;
    private boolean isDelivered;
    private Date deliveredAt;

    @DBRef
    private List<OrderItem> orderItems= new ArrayList<OrderItem>(); //many to one with Product
    @DBRef
    private AppUser user;

    public ProductOrder(Date createdDate) {
        this.createdDate = new Date();
    }
}
