package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.bg.zooshop.entity.Category;

public interface ICategoryRepository extends MongoRepository<Category,Integer> {
}
