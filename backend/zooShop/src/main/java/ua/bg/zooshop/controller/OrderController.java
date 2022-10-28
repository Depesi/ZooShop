package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Order;
import ua.bg.zooshop.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    OrderService service;

    @ApiOperation(value = "Get List with all Orders")
    @GetMapping("/")
    public List<Order> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one Item by id")
    @GetMapping("/{id}")
    public Order getById(@PathVariable(value = "id") int id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Method that creates Orders")
    @PostMapping("/")
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @ApiOperation(value = "Method that updates Orders")
    @PutMapping("/")
    public Order update(@RequestBody Order order) {
        return service.update(order);
    }

    @ApiOperation(value = "Method that removes Orders by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
}
