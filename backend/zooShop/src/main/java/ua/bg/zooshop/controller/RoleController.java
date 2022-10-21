package ua.bg.zooshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Role;
import ua.bg.zooshop.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable(value = "id") int id) {
        return roleService.getById(id);
    }

    @PostMapping("/")
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping("/")
    public Role update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")int id){
        roleService.delete(id);
    }
}
