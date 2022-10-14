package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.bg.zooshop.entity.Item;

public interface IItemRepository extends MongoRepository<Item,Integer> {
}
