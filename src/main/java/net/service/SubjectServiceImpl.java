package net.service;


import net.dao.SubjectDAO;
import net.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO subjectDAO;

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }
    @Transactional
    public void add(Subject subject)  {
        this.subjectDAO.add(subject);
    }
    @Transactional
    public List<Subject> getAll()  {
        return this.subjectDAO.getAll();
    }
    @Transactional
    public Subject getById(int id)  {
        return this.subjectDAO.getById(id);
    }
    @Transactional
    public void update(Subject subject)  {
        this.subjectDAO.update(subject);
    }
    @Transactional
    public void remove(int id)  {
        this.subjectDAO.remove(id);
    }
}
