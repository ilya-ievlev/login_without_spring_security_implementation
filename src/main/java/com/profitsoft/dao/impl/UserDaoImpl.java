package com.profitsoft.dao.impl;

import com.profitsoft.dao.exceptions.DAOException;
import com.profitsoft.dao.exceptions.NoSuchElementException;
import com.profitsoft.dao.interfaces.UserDao;
import com.profitsoft.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String EXCEPTION_WHILE_FINDING_ELEMENT_BY_ID = "exception while finding element by id";
    private static final String ID_NUMBER_IS_WRONG = "id number is wrong";
    private final List<User> userList = fillList();

    @Override
    public User findById(int id) throws DAOException {
        for(User user: userList){
            if (user.getUserId() == id){
                return user;
            }
        }
        throw new DAOException(EXCEPTION_WHILE_FINDING_ELEMENT_BY_ID);
    }

    @Override
    public List<User> findAll(){
        return userList;
    }

    @Override
    public void deleteUserById(int id) throws NoSuchElementException {
        int collectionSize = userList.size();
        if(id>collectionSize||id<0){
            throw new NoSuchElementException(ID_NUMBER_IS_WRONG);
        }
        int i = 0;
        while (i<collectionSize) {
            if(userList.get(i).getUserId()==id){
                break;
            }
                i++;
        }
        userList.remove(i);
    }

    @Override
    public void saveUser(User user){
        userList.add(user);
    }

    @Override
    public User getByLogin(String login){
        for(User user: userList){
            if (user.getUserLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    private List<User> fillList(){
        List<User> userList = new ArrayList<>();

        User user1 = new User(1, "1", "1", "user1");
        User user2 = new User(2, "2", "2", "user2");
        User user3 = new User(3, "3", "3", "user3");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
