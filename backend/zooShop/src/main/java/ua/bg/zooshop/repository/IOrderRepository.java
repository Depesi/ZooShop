package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.bg.zooshop.entity.Order;

@Repository
public interface IOrderRepository extends MongoRepository<Order, String> {
}
