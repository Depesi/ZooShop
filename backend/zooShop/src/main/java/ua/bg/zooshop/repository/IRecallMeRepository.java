package ua.bg.zooshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.bg.zooshop.entity.Recall;

public interface IRecallMeRepository extends MongoRepository<Recall,String> {
}
