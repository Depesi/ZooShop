package ua.bg.zooshop.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Basket;
import ua.bg.zooshop.entity.Order;
import ua.bg.zooshop.entity.User;
import ua.bg.zooshop.service.BasketService;
import ua.bg.zooshop.service.OperatorService;
import ua.bg.zooshop.service.OrderService;
import ua.bg.zooshop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operators")
public class OperatorController {

    @Autowired
    OperatorService operatorService;

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "Show all order by status")
    @GetMapping("/status/{status}")
    @PreAuthorize("hasRole('OPERATOR') or hasRole('ADMIN')")
    public List<Order> status(@PathVariable(value = "status")boolean status){
        return operatorService.statusOrder(status);
    }

    @ApiOperation(value = "Method that creates Orders")
    @PostMapping("/")
    @PreAuthorize("hasRole('OPERATOR')")
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @ApiOperation(value = "Method that updates Orders")
    @PutMapping("/")
    @PreAuthorize("hasRole('OPERATOR')")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @ApiOperation(value = "Method that removes Orders by id")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('OPERATOR')")
    public void delete(@PathVariable(value = "id")String id){
        orderService.delete(id);
    }
}
