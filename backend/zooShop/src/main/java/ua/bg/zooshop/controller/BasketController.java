package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Basket> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one Item by id")
    @GetMapping("/{id}")
    public Basket getById(@PathVariable(value = "id") int id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Method that creates Baskets")
    @PostMapping("/")
    public Basket create(@RequestBody Basket basket) {
        return service.create(basket);
    }

    @ApiOperation(value = "Method that updates Baskets")
    @PutMapping("/")
    public Basket update(@RequestBody Basket basket) {
        return service.update(basket);
    }

    @ApiOperation(value = "Method that removes Baskets by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
}
