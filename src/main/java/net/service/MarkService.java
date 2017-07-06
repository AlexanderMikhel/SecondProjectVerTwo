package net.service;


import net.model.Mark;

import java.sql.SQLException;
import java.util.List;

public interface MarkService {
    //create
    void add(Mark mark) ;
    //read
    List<Mark> getAll() ;
    Mark getById(int id) ;
    //update
    void update(Mark mark) ;
    //remove
    void remove(int id) ;
}
