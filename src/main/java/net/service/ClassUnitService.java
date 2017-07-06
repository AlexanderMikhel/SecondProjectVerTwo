package net.service;


import net.model.ClassUnit;

import java.sql.SQLException;
import java.util.List;

public interface ClassUnitService {

    void add(ClassUnit classUnit);

    List<ClassUnit> getAll() ;
    ClassUnit getById(int id) ;

    void update(ClassUnit classUnit);

    void remove(int id) ;
}
