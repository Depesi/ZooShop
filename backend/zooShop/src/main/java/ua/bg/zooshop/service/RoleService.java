package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Role;
import ua.bg.zooshop.repository.IRoleRepository;

import javax.annotation.PostConstruct;

@Service
public class RoleService {
    Role role = new Role(0,"admin");
    @Autowired
    IRoleRepository repository;

    @PostConstruct
    public void init(){
        repository.save(role);
    }
}
