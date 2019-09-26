package com.assignments.service;


import com.assignments.domain.User;
import com.assignments.repository.IRepository;

import java.util.Set;

public interface UserService extends IService<User, String>{

    Set<User> getAll();
}
