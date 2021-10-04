package com.shopping.ahia.models.userContent;

import com.shopping.ahia.models.productContent.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    @Id
    private String id;
    private AppUser appUser;
    private int rating;
    private String comment;
    private Date createdDate;
    private Product product;

    public Review(Date createdDate) {
        this.createdDate = new Date();
    }
}
