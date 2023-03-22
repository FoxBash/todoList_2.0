package com.paul.todolist.service;

import com.paul.todolist.model.Item;
import com.paul.todolist.repository.AppRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {
    private final AppRepo repo;


    public AppService(AppRepo repo) {
        this.repo = repo;
    }

    public void add(Item item){
        repo.save(item);
    }

    public List<Item> getItems() {
        return repo.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return repo.findById(id);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
