package com.bawa.projectmanaement.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bawa.projectmanaement.domain.CustomerOrder;
import com.bawa.projectmanaement.dto.OrderDTO;
import com.bawa.projectmanaement.exception.OrderCouldNotExeption;
import com.bawa.projectmanaement.repositories.OrderRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private ModelMapper mapper;
    
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @HystrixCommand(fallbackMethod= "defaultResponse")
    public CustomerOrder save(OrderDTO newOrder){
        CustomerOrder order = mapper.map(newOrder, CustomerOrder.class);
        LOG.info("Order Created");
        try {
            return repo.save(order);
        }catch (Exception ex){
            throw new OrderCouldNotExeption("Couldnt finish Order..");
        }
    }
    
    public ResponseEntity<CustomerOrder> defaultResponse() {
		System.out.println("You are seeing this fallback response because the underlying microservice is down or has thrown an error!");

		CustomerOrder fallbackItem = new CustomerOrder();
        fallbackItem.setItemName("default");
        fallbackItem.setItemName("0");

		return new ResponseEntity<CustomerOrder>(fallbackItem, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
