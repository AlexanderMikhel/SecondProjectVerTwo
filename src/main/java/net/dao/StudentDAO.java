package net.dao;


import net.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    //create
    void add(Student student);
    //read
    List<Student> getAll();
    Student getById(int id) ;
    //update
    void update(Student student) ;
    //remove
    void remove(int id) ;
}
