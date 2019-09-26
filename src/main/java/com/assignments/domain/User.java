package com.assignments.domain;

import java.util.Objects;

public class User {

    @Override
    public String toString() {
        return "Builder{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSname='" + userSname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Builder builder = (Builder) o;
        return Objects.equals(userId, builder.userId) &&
                Objects.equals(userName, builder.userName) &&
                Objects.equals(userSname, builder.userSname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userSname);
    }

    private String userId,  userName,  userSname;

    public User(User.Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userSname = builder.userSname;

    }

    public User(){

    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSname() {
        return userSname;
    }

    public void setUserSname(String userSname) {
        this.userSname = userSname;
    }


    public static class Builder{
        private String userId,  userName,  userSname;

        public Builder() {

        }

        public User.Builder userId(String userId){
            this.userId = userId;
            return this;
        }

        public User.Builder userName(String userName){
            this.userName = userName;
            return this;
        }

        public User.Builder userSname(String userSname){
            this.userSname = userSname;
            return this;
        }


        public User.Builder copy(User User){
            this.userId = User.userId;
            this.userName = User.userName;
            this.userSname = User.userSname;
            return this;
        }

        public User build(){
            return new User(this);
        }

        public Builder(String userId, String userName, String userSname) {
            this.userId = userId;
            this.userName = userName;
            this.userSname = userSname;
        }


    }
}
