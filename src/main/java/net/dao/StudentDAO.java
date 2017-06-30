package net.dao;


import net.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
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
