package com.shopping.ahia.models.productContent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Category {
    @Id
    private String id;
    @NotBlank(message="Category name is needed")
    private String categoryName;
    private String categoryIdentifier;
    private String categoryDescription;
    @DBRef
    private ProductLog productLog;
    
}
