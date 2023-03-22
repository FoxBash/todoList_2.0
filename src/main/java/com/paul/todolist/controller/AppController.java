package com.paul.todolist.controller;

import com.paul.todolist.model.Item;
import com.paul.todolist.service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class AppController {
    private final AppService service;

    public AppController(AppService service) {
        this.service = service;
    }
    // crud create, return, update, delete

    @PostMapping("/save")
    public String saveItem(Item item){
        service.add(item);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addItem(Model model){
        model.addAttribute("addItem", new Item());
        return "add";
    }
    @GetMapping("/view/{id}")
    public String viewItem(Model model, @PathVariable Long id){
        Optional<Item> optionalItem = service.getItemById(id);
        if (optionalItem.isPresent()){
            Item item = optionalItem.get();
            model.addAttribute("view",item);
            return "View";
        }
        return null;

    }
    @GetMapping("/")
    public String allItems(Model model){
        model.addAttribute("items", service.getItems()) ;
        return "index";
    }
    @GetMapping("/update/{id}")
    public String updatePage(Model model,@PathVariable Long id){

        Optional<Item> optionalItem = service.getItemById(id);
        if (optionalItem.isPresent()){
            Item item = optionalItem.get();
            model.addAttribute("update",item);
            return "update";
        }
        return null;

    }
    @DeleteMapping("/remove/{id}")
    public void removeItem(@PathVariable Long id){
        service.deleteById(id);
    }

}
