package com.shopping.ahia.serviceImpl;


import com.shopping.ahia.models.orderContent.OrderItem;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.repository.OrderItemRepository;
import com.shopping.ahia.service.OrderItemService;
import com.shopping.ahia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderItemImplementation implements OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ProductService productService;

    @Override
    public OrderItem saveItem(OrderItem orderItem, String productId) throws Exception {
        try{
            Product prod = productService.findByProductId(productId);
            orderItem.setProduct(prod);
            return orderItemRepository.save(orderItem);

        }catch(Exception ex){

            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public OrderItem findByOrderId(String id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public void deleteOrder(String id) {
        OrderItem orderItem = findByOrderId(id);
        orderItemRepository.delete(orderItem);
    }


}
