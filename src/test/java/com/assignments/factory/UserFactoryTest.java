package com.assignments.factory;

import com.assignments.domain.User;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTest {

    @Test
    public void getUser(){

        User User = UserFactory.getUser("1234", "James", "May");
        Assert.assertNotNull(User);
    }

}
