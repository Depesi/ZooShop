package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Category;
import ua.bg.zooshop.entity.Item;
import ua.bg.zooshop.repository.ICategoryRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CategoryService {
    Category category = new Category();
    @Autowired
    ICategoryRepository repository;

//    @PostConstruct
    public void init(){
        repository.save(category);
    }

    public Category create(Category categoryCreate) {
        repository.save(categoryCreate);
        return categoryCreate;
    }

    public Category update(Category categoryCreate) {
        getById(categoryCreate.getId());
        repository.save(categoryCreate);
        return categoryCreate;
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category getById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }
}
