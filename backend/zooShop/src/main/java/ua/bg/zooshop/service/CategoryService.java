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
    Category category = new Category(0,"test");
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
        Category updateCategory = getById(categoryCreate.getId());
        repository.save(updateCategory);
        return updateCategory;
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category getById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }
}
