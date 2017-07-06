package net.service;


import net.dao.TeacherDAO;
import net.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Service
public class TeacherServiceImpl implements TeacherService{

    private TeacherDAO teacherDAO;

    public TeacherDAO getTeacherDAO() {
        return teacherDAO;
    }

    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }
    @Transactional
    public void add(Teacher teacher)  {
        this.teacherDAO.add(teacher);
    }
    @Transactional
    public List<Teacher> getAll()  {
        return this.teacherDAO.getAll();
    }
    @Transactional
    public Teacher getById(int id)  {
        return this.teacherDAO.getById(id);
    }
    @Transactional
    public void update(Teacher teacher)  {
        this.teacherDAO.update(teacher);
    }
    @Transactional
    public void remove(int id)  {
        this.teacherDAO.remove(id);
    }
}
