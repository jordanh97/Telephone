package com.assignments.controller;

import com.assignments.domain.User;
import com.assignments.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl service;

    @PostMapping("/new")
    public User create(@RequestBody User User){

        return service.create(User);
    }

    @GetMapping(path = "/find/{id}")
    public User findById(@PathVariable String id){

        User User = service.read(id);

        return User;
    }

    @PutMapping("/update")
    public void update(@RequestBody User User){

        service.update(User);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getall")
    public Set<User> getAll(){
        return service.getAll();
    }

}

