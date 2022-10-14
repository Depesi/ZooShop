package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.bg.zooshop.entity.Role;

@Repository
public interface IRoleRepository extends MongoRepository<Role,Integer> {
}
