package com.paul.todolist.repository;

import com.paul.todolist.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepo extends JpaRepository<Item, Long> {
}
