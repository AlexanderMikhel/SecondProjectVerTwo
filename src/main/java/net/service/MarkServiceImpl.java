package net.service;


import net.dao.ClassUnitDAO;
import net.dao.MarkDAO;
import net.model.ClassUnit;
import net.model.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Service
public class MarkServiceImpl implements MarkSevice {
    @Autowired
    private MarkDAO markDAO;

    public void add(Mark mark) throws SQLException {
        this.markDAO.add(mark);
    }

    public List<Mark> getAll() throws SQLException {
        return this.markDAO.getAll();
    }

    public Mark getById(int id) throws SQLException {
        return this.markDAO.getById(id);
    }

    public void update(Mark mark) throws SQLException {
        this.markDAO.update(mark);
    }

    public void remove(int id) throws SQLException {
        this.markDAO.remove(id);
    }
}
