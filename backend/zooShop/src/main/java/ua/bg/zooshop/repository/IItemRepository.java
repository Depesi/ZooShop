package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.bg.zooshop.entity.Item;

@Repository
public interface IItemRepository extends MongoRepository<Item,Integer> {
}
