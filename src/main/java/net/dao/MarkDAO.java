package net.dao;

import net.model.Mark;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface MarkDAO {
    //create
    void add(Mark mark) throws SQLException;
    //read
    List<Mark> getAll() throws SQLException;
    Mark getById(int id) throws SQLException;
    //update
    void update(Mark mark) throws SQLException;
    //remove
    void remove(int id) throws SQLException;

}
