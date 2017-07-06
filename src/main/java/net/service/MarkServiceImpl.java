package net.service;


import net.dao.MarkDAO;
import net.model.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Service

public class MarkServiceImpl implements MarkService{

    private MarkDAO markDAO;

    public void setMarkDAO(MarkDAO markDAO) {
        this.markDAO = markDAO;
    }
    @Transactional
    public void add(Mark mark)  {
        this.markDAO.add(mark);
    }
    @Transactional
    public List<Mark> getAll()  {
        return this.markDAO.getAll();
    }
    @Transactional
    public Mark getById(int id)  {
        return this.markDAO.getById(id);
    }
    @Transactional
    public void update(Mark mark)  {
        this.markDAO.update(mark);
    }
    @Transactional
    public void remove(int id)  {
        this.markDAO.remove(id);
    }
}