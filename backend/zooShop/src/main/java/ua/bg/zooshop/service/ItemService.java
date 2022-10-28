package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Item;
import ua.bg.zooshop.repository.IItemRepository;

import java.util.List;

@Service
public class ItemService {

    Item item = new Item();

    @Autowired
    IItemRepository repository;

    //    @PostConstruct
    public void init() {
        repository.save(item);
    }

    public Item create(Item itemCreate) {
        repository.save(itemCreate);
        return itemCreate;
    }

    public Item update(Item itemCreate) {
        getById(itemCreate.getId());
        repository.save(itemCreate);
        return itemCreate;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Item getById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }

    public Item getFindByName(String name) {
        return repository.findItemByName(name);
    }
}
