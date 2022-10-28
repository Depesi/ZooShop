package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.bg.zooshop.entity.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
}
