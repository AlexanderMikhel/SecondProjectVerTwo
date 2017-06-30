package net.service;


import net.dao.SubjectDAO;
import net.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDAO subjectDAO;

    public void add(Subject subject) throws SQLException {
        this.subjectDAO.add(subject);
    }

    public List<Subject> getAll() throws SQLException {
        return this.subjectDAO.getAll();
    }

    public Subject getById(int id) throws SQLException {
        return this.subjectDAO.getById(id);
    }

    public void update(Subject subject) throws SQLException {
        this.subjectDAO.update(subject);
    }

    public void remove(int id) throws SQLException {
        this.subjectDAO.remove(id);
    }
}
