package com.example.springbootrestfulmongodb;

import com.example.springbootrestfulmongodb.user.Repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {
        Repository.class,
})

@SpringBootApplication
public class SpringbootRestfulMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulMongodbApplication.class, args);
    }

}
