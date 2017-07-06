package net.service;


import net.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    //create
    void add(Student student) ;
    //read
    List<Student> getAll() ;
    Student getById(int id) ;
    //update
    void update(Student student) ;
    //remove
    void remove(int id) ;
}
