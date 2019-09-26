package com.assignments.repository;

import com.assignments.domain.User;
import com.assignments.factory.UserFactory;
import com.assignments.repository.impl.UserRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {
    @Autowired
    private UserRepositoryImpl userRepository;
    User user = UserFactory.getUser("1234", "Richard", "Hammond");

    @Test
    public void a_create() {

        userRepository.create(user);
        assertNotNull(userRepository.getAll());
        System.out.println(userRepository.getAll());

    }

    @Test
    public void b_read() {

        User fromSet = userRepository.read(user.getUserId());
        assertNotNull(fromSet);
        System.out.println(userRepository.getAll());
    }

    @Test
    public void c_update() {


        User updatedUser  = UserFactory.getUser("1234", "Richard", "Smith");
        userRepository.update(updatedUser);
        Assert.assertNotEquals(user.getUserSname(), updatedUser.getUserSname());
        System.out.println(userRepository.getAll());



    }

    @Test
    public void d_delete() {

        assertNotNull(userRepository.getAll());
        userRepository.delete(user.getUserId());
        User userTor = userRepository.read(user.getUserId());
        assertNull(userTor);
        System.out.println(userRepository.getAll());

    }

}

