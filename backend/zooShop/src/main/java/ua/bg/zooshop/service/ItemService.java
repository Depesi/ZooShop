package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Category;
import ua.bg.zooshop.entity.Item;
import ua.bg.zooshop.repository.IItemRepository;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.Arrays;
@Service
public class ItemService {

    Item item = new Item(1,"test",123,321,"Test", Arrays.asList(new Category(0,"test")),
            "sadads",1010,12);

    @Autowired
    IItemRepository  repository;

    @PostConstruct
    public void init(){
        repository.save(item);
    }
}
