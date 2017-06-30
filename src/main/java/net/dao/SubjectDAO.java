package net.dao;

import net.model.Subject;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface SubjectDAO {
    //create
    void add(Subject subject) throws SQLException;
    //read
    List<Subject> getAll() throws SQLException;
    Subject getById(int id) throws SQLException;
    //update
    void update(Subject subject) throws SQLException;
    //remove
    void remove(int id) throws SQLException;
}
