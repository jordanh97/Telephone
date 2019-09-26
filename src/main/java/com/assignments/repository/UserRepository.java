package com.assignments.repository;


import com.assignments.domain.User;
import com.assignments.repository.IRepository;

import java.util.Set;

public interface UserRepository extends IRepository<User, String>{

    Set<User> getAll();
}
