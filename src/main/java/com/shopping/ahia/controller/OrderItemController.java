package com.shopping.ahia.controller;

import com.shopping.ahia.errorMapping.ErrorMapping;
import com.shopping.ahia.models.orderContent.OrderItem;
import com.shopping.ahia.models.productContent.Category;
import com.shopping.ahia.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@SpringBootApplication
@RequestMapping("/api/orderItem")
@CrossOrigin
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ErrorMapping errorMapping;

    @PostMapping("/{productId}")
    public ResponseEntity<?> saveOrderItem(@Valid @ModelAttribute OrderItem orderItem, String productId, BindingResult result)throws Exception{
        ResponseEntity<?> errorMap = errorMapping.ErrorMappingService(result);
        if(errorMap != null){
            return errorMap;
        }
        OrderItem orderItem1 = orderItemService.saveItem(orderItem, productId);
        return new ResponseEntity<OrderItem>(orderItem1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public OrderItem getOrderById(@PathVariable String id){
        return orderItemService.findByOrderId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteItem(@PathVariable String id){
            orderItemService.deleteOrder(id);
            return new ResponseEntity<String>("Order with ID: " + id + " was deleted", HttpStatus.OK);
    }



}
