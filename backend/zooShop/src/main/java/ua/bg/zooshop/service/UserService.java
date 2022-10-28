package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.config.EncoderPassword;
import ua.bg.zooshop.entity.User;
import ua.bg.zooshop.repository.IUserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository repository;

    @Autowired
    EncoderPassword encoderPassword;

    public User create(User userCreate) {
        userCreate.setPassword(encoderPassword.EncodingPassword(userCreate.getPassword()));
        repository.save(userCreate);
        return userCreate;
    }

    public User update(User userCreate) {
        User userItem = getById(userCreate.getId());
        boolean isOldPassword = encoderPassword.EqualsPassword(userItem.getPassword(),userCreate.getPassword());
        if(isOldPassword){
            userItem.setPassword(encoderPassword.EncodingPassword(userCreate.getPassword()));
        }
        userItem.setDiscount(userCreate.getDiscount());
        userItem.setId(userCreate.getId());
        userItem.setEmail(userCreate.getEmail());
        userItem.setFirstName(userCreate.getFirstName());
        userItem.setLastName(userCreate.getLastName());
        userItem.setPhone(userCreate.getPhone());
        userItem.setSurrName(userCreate.getSurrName());
        userItem.setUsername(userCreate.getUsername());
        userItem.setRole(userCreate.getRole());
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
