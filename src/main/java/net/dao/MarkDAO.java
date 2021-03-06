package net.dao;

import net.model.Mark;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface MarkDAO {
    //create
    void add(Mark mark);
    //read
    List<Mark> getAll() ;
    Mark getById(int id) ;
    //update
    void update(Mark mark) ;
    //remove
    void remove(int id) ;

}
