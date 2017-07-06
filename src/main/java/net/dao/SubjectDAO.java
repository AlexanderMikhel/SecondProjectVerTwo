package net.dao;

import net.model.Subject;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface SubjectDAO {
    //create
    void add(Subject subject);
    //read
    List<Subject> getAll();
    Subject getById(int id);
    //update
    void update(Subject subject);
    //remove
    void remove(int id);
}
