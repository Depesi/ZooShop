package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.User;
import ua.bg.zooshop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService service;

    @ApiOperation(value = "Get List with all Users")
    @GetMapping("/")
    public List<User> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one Item by id")
    @GetMapping("/{id}")
    public User getById(@PathVariable(value = "id") int id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Method that creates Users")
    @PostMapping("/")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @ApiOperation(value = "Method that updates Users")
    @PutMapping("/")
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @ApiOperation(value = "Method that removes Users by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
}
