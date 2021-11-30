package com.shopping.ahia.repository;

import com.shopping.ahia.models.orderContent.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, Long> {
    OrderItem findById(String id);
}
