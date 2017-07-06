package net.dao;

import net.model.Teacher;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {
    //create
    void add(Teacher teacher);
    //read
    List<Teacher> getAll() ;
    Teacher getById(int id);
    //update
    void update(Teacher teacher);
    //remove
    void remove(int id) ;
}
