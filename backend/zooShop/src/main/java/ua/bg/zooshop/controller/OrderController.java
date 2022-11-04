package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('OPERATOR')")
    public List<Order> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one Item by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OPERATOR')")
    public Order getById(@PathVariable(value = "id") String id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Method that creates Orders")
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OPERATOR')")
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @ApiOperation(value = "Method that updates Orders")
    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OPERATOR')")
    public Order update(@RequestBody Order order) {
        return service.update(order);
    }

    @ApiOperation(value = "Method that removes Orders by id")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OPERATOR')")
    public void delete(@PathVariable(value = "id")String id){
        service.delete(id);
    }
}
