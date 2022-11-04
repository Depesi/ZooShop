package ua.bg.zooshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.bg.zooshop.entity.Order;
import ua.bg.zooshop.service.OperatorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operators")
public class OperatorController {

    @Autowired
    OperatorService operatorService;

    @GetMapping("/status/{status}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OPERATOR')")
    public List<Order> status(@PathVariable(value = "status")boolean status){
        return operatorService.statusOrder(status);
    }
}
