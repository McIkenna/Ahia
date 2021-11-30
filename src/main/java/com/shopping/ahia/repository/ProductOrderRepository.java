package com.shopping.ahia.repository;

import com.shopping.ahia.models.orderContent.ProductOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends MongoRepository<ProductOrder, Long> {
        ProductOrder findById(String id);
        //ProductOrder save(ProductOrder order, String orderId);
}
