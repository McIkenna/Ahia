package com.shopping.ahia.models.productContent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ProductLog {
    @Id
    private String id;
    private String categoryIdentifier;
    private Integer productSequence=0;
    private Category category;
    private List<Product> products = new ArrayList<>();
}
