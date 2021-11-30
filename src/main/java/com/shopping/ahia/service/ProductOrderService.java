package com.shopping.ahia.service;

import com.shopping.ahia.models.orderContent.ProductOrder;
import org.springframework.stereotype.Component;

@Component
public interface ProductOrderService {

    ProductOrder saveProductOrder(ProductOrder productOrder, String orderId) throws Exception;
    ProductOrder findOrderById(String id);
    void deleteOrderById(String id);
}
