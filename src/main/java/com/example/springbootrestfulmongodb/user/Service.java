package com.example.springbootrestfulmongodb.user;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repository;

    public User create(String userName, String userFamily) {
        if (userName.isEmpty() || userFamily.isEmpty()) {
            System.out.println("empty field exception");
        }

        User user = new User(userName, userFamily);
        user.setUpdatedAt(new Date());
        user.setCreateAt(new Date());
        user.setDeleted(false);

        return repository.save(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User update(String id, String name, String family) {
        if (id.isEmpty()) {
            System.out.println("empty field exception");
        }

        User user = repository.findById(id)
                .orElseThrow(() -> new NullPointerException("user not found for this id : " + id));

        if (!name.isEmpty()) {
            user.setName(name);
        }
        if (!family.isEmpty()) {
            user.setFamily(family);
        }

        user.setUpdatedAt(new Date());

        return repository.save(user);
    }

    public void delete(String id) {
        if (id.isEmpty()) {
            System.out.println("empty field exception");
        }

        User user = repository.findById(id)
                .orElseThrow(() -> new NullPointerException("user not found for this id : " + id));

        user.setDeleted(true);
    }
}
