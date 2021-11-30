package com.shopping.ahia.controller;

import com.shopping.ahia.errorMapping.ErrorMapping;
import com.shopping.ahia.models.orderContent.OrderItem;
import com.shopping.ahia.models.orderContent.ProductOrder;
import com.shopping.ahia.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@SpringBootApplication
@RequestMapping("/api/productOrder")
@CrossOrigin
public class ProductOrderController {

    @Autowired
    ProductOrderService productOrderService;
    @Autowired
    ErrorMapping errorMapping;

    @PostMapping("/{orderId}")
    public ResponseEntity<?> saveProdOrder(@Valid @ModelAttribute ProductOrder productOrder, String orderId, BindingResult result)throws Exception{
        ResponseEntity<?> errorMap = errorMapping.ErrorMappingService(result);
        if(errorMap != null){
            return errorMap;
        }
        ProductOrder productOrder1 = productOrderService.saveProductOrder(productOrder, orderId);
        return new ResponseEntity<ProductOrder>(productOrder1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ProductOrder getprodOrderById(@PathVariable String id){
        return productOrderService.findOrderById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable String id){
        productOrderService.deleteOrderById(id);
        return new ResponseEntity<String>("ProductOrder with ID: " + id + " was deleted", HttpStatus.OK);
    }
}
