package ua.bg.zooshop.controller;

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

    @GetMapping("/")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(value = "id") int id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("/")
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
}
