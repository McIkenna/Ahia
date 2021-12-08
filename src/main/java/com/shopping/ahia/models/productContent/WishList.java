package com.shopping.ahia.models.productContent;

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
public class WishList {
    @Id
    private String id;
    @DBRef
    private Date createdDate;
    @DBRef
    private List<Product> product = new ArrayList<>();

}
