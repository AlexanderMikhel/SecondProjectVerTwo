package net.dao;

import net.model.ClassUnit;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface ClassUnitDAO {
    //create
    void add(ClassUnit classUnit) throws SQLException;
    //read
    List<ClassUnit> getAll() throws SQLException;
    ClassUnit getById(int id) throws SQLException;
    //update
    void update(ClassUnit classUnit) throws SQLException;
    //remove
    void remove(int id) throws SQLException;
}
