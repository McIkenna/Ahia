package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.orderContent.OrderItem;
import com.shopping.ahia.models.orderContent.ProductOrder;
import com.shopping.ahia.repository.ProductOrderRepository;
import com.shopping.ahia.service.OrderItemService;
import com.shopping.ahia.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderImplementation implements ProductOrderService {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    OrderItemService orderItemService;


    @Override
    public ProductOrder saveProductOrder(ProductOrder productOrder, String orderId) throws Exception {
       try{
           OrderItem orderItem = orderItemService.findByOrderId(orderId);

           int qty = orderItem.getQuantity();
           double price = orderItem.getPrice();
           productOrder.setTotalQuantity(productOrder.getTotalQuantity() + qty);
           productOrder.setTotalPrice(productOrder.getTotalPrice() + price);
           productOrder.setShippingPrice(productOrder.getTotalQuantity() * 0.07);
           productOrder.setTaxPrice(productOrder.getTotalPrice() * 0.05);

           productOrder.getOrderItems().add(orderItem);
           return productOrderRepository.save(productOrder);
       }catch(Exception ex){
           throw new Exception(ex.getMessage());
       }
    }

    @Override
    public ProductOrder findOrderById(String id) {
        return productOrderRepository.findById(id);
    }

    @Override
    public void deleteOrderById(String id) {
        ProductOrder prodOrder = findOrderById(id);
        productOrderRepository.delete(prodOrder);
    }
}
