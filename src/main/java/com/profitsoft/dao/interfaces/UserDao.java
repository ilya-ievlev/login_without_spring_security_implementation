package com.profitsoft.dao.interfaces;

import com.profitsoft.dao.exceptions.DAOException;
import com.profitsoft.dao.exceptions.NoSuchElementException;
import com.profitsoft.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    User findById(int id) throws DAOException;

    List<User> findAll();

    void deleteUserById(int id) throws NoSuchElementException;

    void saveUser(User user);

    User getByLogin(String login);
}
