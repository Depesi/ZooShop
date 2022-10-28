package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.bg.zooshop.entity.Category;

@Repository
public interface ICategoryRepository extends MongoRepository<Category, String> {
}
