package com.shopping.ahia.models.orderContent;

import com.shopping.ahia.models.productContent.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    private String id;
    private String name;
    private int quantity;
    private double price;
    private Date createdDate;
    @DBRef
    private ProductOrder productOrder;
    @DBRef
    private Product product;

    public OrderItem(Date createdDate) {
        this.createdDate = new Date();
    }
}
