package com.shopping.ahia.models.productContent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Product {
    @Id
    private String id;
    @DBRef
    private Brand brand; //one to One
    private ProductLog productLog;
    private String categoryIdentifier;
    private String productSequence;
    private String productName;
    private String productSummary;
    private String productDescription;
    private double price;
    private int countInStock;
    private double rating;
    private int numOfReviews;
}
