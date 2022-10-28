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
        getById(userCreate.getId());

        boolean isOldPassword = encoderPassword.EqualsPassword(userCreate.getPassword(),userCreate.getPassword());
        if(isOldPassword){
            userCreate.setPassword(encoderPassword.EncodingPassword(userCreate.getPassword()));
        }

        repository.save(userCreate);
        return userCreate;
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
