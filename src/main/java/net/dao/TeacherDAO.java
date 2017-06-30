package net.dao;

import net.model.Teacher;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {
    //create
    void add(Teacher teacher) throws SQLException;
    //read
    List<Teacher> getAll() throws SQLException;
    Teacher getById(int id) throws SQLException;
    //update
    void update(Teacher teacher) throws SQLException;
    //remove
    void remove(int id) throws SQLException;
}
