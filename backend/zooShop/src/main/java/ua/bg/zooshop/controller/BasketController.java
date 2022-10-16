package ua.bg.zooshop.controller;

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

    @GetMapping("/")
    public List<Basket> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Basket getById(@PathVariable(value = "id") int id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public Basket create(@RequestBody Basket basket) {
        return service.create(basket);
    }

    @PutMapping("/")
    public Basket update(@RequestBody Basket basket) {
        return service.update(basket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
}
