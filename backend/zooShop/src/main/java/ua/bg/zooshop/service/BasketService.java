package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Basket;
import ua.bg.zooshop.repository.IBasketRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BasketService {
    Basket basket = new Basket();
    @Autowired
    IBasketRepository repository;

//    @PostConstruct
    public void init(){
        repository.save(basket);
    }

    public Basket create(Basket basketCreate) {
        repository.save(basketCreate);
        return basketCreate;
    }

    public Basket update(Basket basketCreate) {
        Basket updateBasket = getById(basketCreate.getId());
        repository.save(updateBasket);
        return updateBasket;
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<Basket> getAll() {
        return repository.findAll();
    }

    public Basket getById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }
}
