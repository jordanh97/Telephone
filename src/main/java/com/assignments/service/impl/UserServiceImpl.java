package com.assignments.service.impl;

import com.assignments.domain.User;
import com.assignments.service.UserService;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("UserServiceImpl")
public class UserServiceImpl implements UserService {

    private static  UserServiceImpl repository = null;
    private Set<User> Users;

    public UserServiceImpl(){
        Users = new HashSet<>();
    }


    public static UserServiceImpl getRepository() {

        if(repository == null){
            return new UserServiceImpl();
        }
        return repository;
    }

    @Override
    public User create(User userInstance) {

        Users.add(userInstance);
        return userInstance;
    }

    @Override
    public User read(String id) {

        return Users.stream().filter(userInstance -> userInstance.getUserId().equals(id)).findAny().orElse(null);
    }

    @Override
    public User update(User userInstance) {

        User inDB = read(userInstance.getUserId());

        if(inDB != null){
            Users.remove(inDB);
            Users.add(userInstance);
            return userInstance;
        }

        return null;
    }

    @Override
    public void delete(String id) {

        User inDB = read(id);
        Users.remove(inDB);

    }

    @Override
    public Set<User> getAll() {
        return Users;
    }

}

