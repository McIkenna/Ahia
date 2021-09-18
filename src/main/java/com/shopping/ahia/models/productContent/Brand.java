package com.shopping.ahia.models.productContent;

import com.shopping.ahia.models.productContent.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    private ObjectId id;
    @NotBlank(message="BrandName is required")
    private String brandName;
    @DBRef
    private List<Product> products; // one to Many

}
