package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.bg.zooshop.entity.Basket;

@Repository
public interface IBasketRepository extends MongoRepository<Basket,Integer> {
}
