package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.entity.Recall;
import ua.bg.zooshop.entity.User;
import ua.bg.zooshop.service.RecallService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recalls")
public class RecallController {

    @Autowired
    RecallService service;

    @ApiOperation(value = "Get all recalls")
    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Recall> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one Recall by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Recall getById(@PathVariable(value = "id") String id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Method that creates Recall")
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Recall create(@RequestBody Recall recall) {
        return service.create(recall);
    }

    @ApiOperation(value = "Method that updates Recall")
    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public Recall update(@RequestBody Recall recall) {
        return service.update(recall);
    }

    @ApiOperation(value = "Method that removes Recall by id")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable(value = "id")String id){
        service.delete(id);
    }
}
