package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Role;
import ua.bg.zooshop.repository.IRoleRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RoleService {
    Role role = new Role(0, "admin");
    @Autowired
    IRoleRepository repository;

    //    @PostConstruct
    public void init() {
        repository.save(role);
    }

    public Role create(Role roleCreate) {
        repository.save(roleCreate);
        return roleCreate;
    }

    public Role update(Role roleCreate) {
        Role updateRole = getById(roleCreate.getId());
        repository.save(updateRole);
        return updateRole;
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<Role> getAll() {
        return repository.findAll();
    }

    public Role getById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }
}
