package com.bawa.projectmanaement.web;

import com.bawa.projectmanaement.domain.CustomerOrder;
import com.bawa.projectmanaement.dto.OrderDTO;
import com.bawa.projectmanaement.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    private static Logger log = LoggerFactory.getLogger(OrderService.class);
    
    @PostMapping("/new")
    public ResponseEntity<?> createNewOrder( @RequestBody OrderDTO project){
        try {
            CustomerOrder save = service.save(project);
            log.info("order processing");
            return new ResponseEntity<CustomerOrder>(save, HttpStatus.CREATED);
        } catch (Exception e) {
            //TODO: handle exception
        }
        return null;

        
    }
    

}

