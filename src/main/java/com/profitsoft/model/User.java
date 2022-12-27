package com.profitsoft.model;

import java.util.Objects;

public class User {
    private int userId;
    private String userLogin;
    private String userPassword;
    private String name;

    public User(int userId, String userLogin, String userPassword, String name) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.name = name;
        this.userId = userId;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userLogin, user.userLogin) && Objects.equals(userPassword, user.userPassword) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, userPassword, name);
    }
}
