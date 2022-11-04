package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Basket;
import ua.bg.zooshop.service.BasketService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/baskets")
public class BasketController {

    @Autowired
    BasketService service;

    @ApiOperation(value = "Get List with all Baskets")
    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Basket> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one Item by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Basket getById(@PathVariable(value = "id") String id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Method that creates Baskets")
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Basket create(@RequestBody Basket basket) {
        return service.create(basket);
    }

    @ApiOperation(value = "Method that updates Baskets")
    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Basket update(@RequestBody Basket basket) {
        return service.update(basket);
    }

    @ApiOperation(value = "Method that removes Baskets by id")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(id);
    }
}
