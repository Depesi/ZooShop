package ua.bg.zooshop.controller;

import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.bg.zooshop.DTO.LoginRequest;
import ua.bg.zooshop.DTO.LoginResponse;
import ua.bg.zooshop.DTO.SignUpRequest;
import ua.bg.zooshop.entity.User;
import ua.bg.zooshop.security.AuthService;
import ua.bg.zooshop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    AuthService authService;

    @ApiOperation(value = "Get List with all Users")
    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get one User by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public User getById(@PathVariable(value = "id") String id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Method that creates Users")
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @ApiOperation(value = "Method that updates Users")
    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @ApiOperation(value = "Method that removes Users by id")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable(value = "id")String id){
        service.delete(id);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.authenticateRequest(request));
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authService.signUpUser(request));
    }
}
