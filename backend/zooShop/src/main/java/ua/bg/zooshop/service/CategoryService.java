package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Category;
import ua.bg.zooshop.repository.ICategoryRepository;

import javax.annotation.PostConstruct;
@Service
public class CategoryService {
    Category category = new Category(0,"test");
    @Autowired
    ICategoryRepository repository;

    @PostConstruct
    public void init(){
        repository.save(category);
    }
}
