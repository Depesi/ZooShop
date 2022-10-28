package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Category;
import ua.bg.zooshop.entity.Item;
import ua.bg.zooshop.entity.Role;
import ua.bg.zooshop.repository.IItemRepository;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    Item item = new Item(1,"test",123,321,"Test", Arrays.asList(new Category(0,"test")),
            "sadads",1010,12);

    @Autowired
    IItemRepository  repository;

//    @PostConstruct
    public void init(){
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

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Item getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }

    public Item getFindByName(String name){
        return repository.findItemByName(name);
    }
}
