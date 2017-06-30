package net.service;


import net.model.ClassUnit;

import java.sql.SQLException;
import java.util.List;

public interface ClassUnitService {

    void add(ClassUnit classUnit) throws SQLException;

    List<ClassUnit> getAll() throws SQLException;
    ClassUnit getById(int id) throws SQLException;

    void update(ClassUnit classUnit) throws SQLException;

    void remove(int id) throws SQLException;
}
