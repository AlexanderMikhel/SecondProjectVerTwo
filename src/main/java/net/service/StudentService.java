package net.service;


import net.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    //create
    void add(Student student) throws SQLException;
    //read
    List<Student> getAll() throws SQLException;
    Student getById(int id) throws SQLException;
    //update
    void update(Student student) throws SQLException;
    //remove
    void remove(int id) throws SQLException;
}
