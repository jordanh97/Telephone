package com.assignments.service;

import com.assignments.domain.User;
import com.assignments.factory.UserFactory;
import com.assignments.service.impl.UserServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;
    User user = UserFactory.getUser("1234", "12321", "Thomas");

    @Test
    public void a_create() {


        userService.create(user);

        assertNotNull(userService.getAll());
        System.out.println(userService.getAll());
    }

    @Test
    public void b_read() {


        assertNotNull(userService.getAll());
        User user1 = userService.read(user.getUserId());
        assertNotNull(user1);
        System.out.println(userService.getAll());


    }

    @Test
    public void c_update() {

        assertNotNull(userService.getAll());
        User user1 = UserFactory.getUser("1234", "12321", "Matt");
        user1.setUserId(user.getUserId());
        userService.update(user1);
        User user2 = userService.read(user1.getUserId());
        assertEquals(user1, user2);
        System.out.println(userService.getAll());

    }

    @Test
    public void d_delete() {
        assertNotNull(userService.getAll());
        userService.delete(user.getUserId());
        User notInSet = userService.read(user.getUserId());
        assertNull(notInSet);
        System.out.println(userService.getAll());
    }
}
