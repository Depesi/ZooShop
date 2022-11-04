package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Category;
import ua.bg.zooshop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryService service;

    @ApiOperation(value = "Get List with all Categories")
    @GetMapping("/")
    public List<Category> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one Item by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Category getById(@PathVariable(value = "id") String id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Method that creates Categories")
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    @ApiOperation(value = "Method that updates Categories")
    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    @ApiOperation(value = "Method that removes Categories by id")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable(value = "id")String id){
        service.delete(id);
    }
}
