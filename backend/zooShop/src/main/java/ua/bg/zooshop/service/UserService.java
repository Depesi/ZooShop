package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.User;
import ua.bg.zooshop.repository.IUserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository repository;


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public User create(User userCreate) {
        userCreate.setPassword(bCryptPasswordEncoder.encode(userCreate.getPassword()));
        repository.save(userCreate);
        return userCreate;
    }

    public User update(User userCreate) {
        getById(userCreate.getId());

        boolean isOldPassword = bCryptPasswordEncoder.matches(userCreate.getPassword(), userCreate.getPassword());
        if (isOldPassword) {
            userCreate.setPassword(bCryptPasswordEncoder.encode(userCreate.getPassword()));
        }

        repository.save(userCreate);
        return userCreate;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found ID"));
    }

}
