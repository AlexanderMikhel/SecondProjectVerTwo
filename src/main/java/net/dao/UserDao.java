package net.dao;

import net.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {
    private List<User> users = Arrays.asList(new User("admin","admin"),new User("user","user"));
    public List<User> getAllUsers(){
        return users;
    }
}
