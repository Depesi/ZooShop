package ua.bg.zooshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Item;
import ua.bg.zooshop.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/")
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable(value = "id") int id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public Item create(@RequestBody Item item) {
        return service.create(item);
    }

    @PutMapping("/")
    public Item update(@RequestBody Item item) {
        return service.update(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
}
