package net.service;

import net.dao.UserDao;
import net.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){
        return  userDao.getAllUsers();
    }
}
