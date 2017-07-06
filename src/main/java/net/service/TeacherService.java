package net.service;

import net.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    //create
    void add(Teacher teacher) ;
    //read
    List<Teacher> getAll() ;
    Teacher getById(int id) ;
    //update
    void update(Teacher teacher);
    //remove
    void remove(int id) ;
}
