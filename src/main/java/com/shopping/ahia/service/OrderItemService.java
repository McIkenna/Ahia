package com.shopping.ahia.service;

import com.shopping.ahia.models.orderContent.OrderItem;
import org.springframework.stereotype.Component;

@Component
public interface OrderItemService {

    OrderItem saveItem(OrderItem orderItem, String productId) throws Exception;
    OrderItem findByOrderId(String id);
    void deleteOrder(String id);
}
