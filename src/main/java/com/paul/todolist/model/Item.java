package com.paul.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Item")
public class Item  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Context data", columnDefinition = "TEXT")
    private String context;
}
