package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Item;
import ua.bg.zooshop.entity.User;
import ua.bg.zooshop.repository.IUserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository repository;

    public User create(User userCreate) {
        repository.save(userCreate);
        return userCreate;
    }

    public User update(User userCreate) {
        User userItem = getById(userCreate.getId());
        repository.save(userItem);
        return userItem;
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }
}
