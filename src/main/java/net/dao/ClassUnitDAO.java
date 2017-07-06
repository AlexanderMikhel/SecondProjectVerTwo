package net.dao;

import net.model.ClassUnit;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface ClassUnitDAO {
    //create
    void add(ClassUnit classUnit);
    //read
    List<ClassUnit> getAll();
    ClassUnit getById(int id);
    //update
    void update(ClassUnit classUnit);
    //remove
    void remove(int id);
}
