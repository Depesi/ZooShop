package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Order;
import ua.bg.zooshop.repository.IOrderRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class OrderService {
//    Order order = new Order("1",null,true);

    @Autowired
    IOrderRepository repository;

//        @PostConstruct
//    public void init() {
//        repository.save(order);
//    }

    public Order create(Order orderCreate) {
        repository.save(orderCreate);
        return orderCreate;
    }

    public Order update(Order orderCreate) {
        getById(orderCreate.getId());
        repository.save(orderCreate);
        return orderCreate;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }
}
