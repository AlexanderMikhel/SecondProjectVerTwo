package net.service;

import net.model.Subject;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface SubjectService {
    //create
    void add(Subject subject);
    //read
    List<Subject> getAll() ;
    Subject getById(int id) ;
    //update
    void update(Subject subject) ;
    //remove
    void remove(int id) ;
}
