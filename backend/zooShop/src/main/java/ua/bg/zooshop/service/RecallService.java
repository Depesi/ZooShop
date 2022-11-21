package ua.bg.zooshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bg.zooshop.entity.Recall;
import ua.bg.zooshop.repository.IRecallMeRepository;

import java.util.List;

@Service
public class RecallService {

    @Autowired
    IRecallMeRepository repository;

    public List<Recall> getAll(){
        return repository.findAll();
    }

    public Recall create(Recall recall){
        return repository.save(recall);
    }

    public Recall getById(String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public Recall update(Recall newRecall){
        Recall update = getById(newRecall.getId());
        update.setId(newRecall.getId());
        update.setNumber(newRecall.getNumber());
        return update;
    }
}
