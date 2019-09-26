package com.assignments.factory;


import com.assignments.domain.User;

public class UserFactory {

    public static User getUser(String userId, String userName, String userSname){
        return new User.Builder().userId(userId).userName(userName).userSname(userSname).build();
    }

}
