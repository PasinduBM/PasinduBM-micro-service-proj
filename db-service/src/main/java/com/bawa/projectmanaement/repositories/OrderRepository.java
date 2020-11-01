package com.bawa.projectmanaement.repositories;

import com.bawa.projectmanaement.domain.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder,Long> {
    
}
