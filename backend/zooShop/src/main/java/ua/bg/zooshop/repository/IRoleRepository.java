package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.bg.zooshop.entity.Role;

import java.util.Optional;

public interface IRoleRepository extends MongoRepository<Role,Integer> {
    Optional<Role> findByName(Role.ERole name);
}
