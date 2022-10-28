package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ua.bg.zooshop.entity.Item;

@Repository
public interface IItemRepository extends MongoRepository<Item, String> {
    @Query("{ 'name' : ?0 }")
    Item findItemByName(String name);
}
