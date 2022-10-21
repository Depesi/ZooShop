package ua.bg.zooshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Category;
import ua.bg.zooshop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/")
    public List<Category> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable(value = "id") int id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    @PutMapping("/")
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
}
