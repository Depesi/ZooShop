package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Role;
import ua.bg.zooshop.repository.IRoleRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleService {
    List<Role> roleList = new ArrayList<>(Arrays.asList(
            new Role(0,Role.ERole.ROLE_ADMIN),
            new Role(1,Role.ERole.ROLE_USER)
    ));
    @Autowired
    IRoleRepository repository;


        //@PostConstruct
    public void init() {
        repository.saveAll(roleList);
    }
}
