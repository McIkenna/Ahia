package com.shopping.ahia.models.userContent;

import com.shopping.ahia.models.orderContent.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShippingAddress {
    @Id
    private String id;
    private ProductOrder productOrder;
    private Address address;
}
