package net.service;

import net.model.Subject;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface SubjectService {
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
