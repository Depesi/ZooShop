package ua.bg.zooshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Order;
import ua.bg.zooshop.repository.IOrderRepository;

import java.util.List;

@Service
public class OperatorService {

    @Autowired
    IOrderRepository repository;

    public List<Order> statusOrder(boolean status){
        return repository.findByStatus(status);
    }
}
