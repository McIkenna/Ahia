package com.shopping.ahia.models.productContent;

import com.shopping.ahia.models.cartContent.Cart;
import com.shopping.ahia.models.common.Size;
import com.shopping.ahia.models.userContent.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Product {
    @Id
    private String id;
    private String brand; //one to One
    private String categoryId;
    private String categoryName;
    private String productName;
    private String productSummary;
    private String productDescription;
    private Size itemSize;
    private Binary mainImage;
    private List<Binary> extraImages = new ArrayList<>();

    private double price;
    private int countInStock;
    private double rating;
    private int numOfReviews;
    private Date dateCreated;
    @DBRef
    private Category category;
    @DBRef
    private List<Cart> carts = new ArrayList<Cart>();
    @DBRef
    private List<WishList> wishLists = new ArrayList<WishList>();
    @DBRef
    private List<Review> review = new ArrayList<Review>();

    public Product(Date dateCreated) {
        this.dateCreated = new Date();
    }
}
