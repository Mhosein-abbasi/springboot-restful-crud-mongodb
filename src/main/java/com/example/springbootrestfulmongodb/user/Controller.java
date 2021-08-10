package com.example.springbootrestfulmongodb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    Service service;

    @PostMapping("/create")
    public User create(@RequestParam String name, @RequestParam String family) {
        return service.create(name, family);
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        return service.getAll();
    }

    @PutMapping("/update")
    public User update(@RequestParam String id, @RequestParam String name, @RequestParam String family) {
        return service.update(id, name, family);
    }

    @DeleteMapping
    public String delete(@RequestParam String id){
        service.delete(id);

        return "user id deleted ...";
    }
}

