package net.service;


import net.dao.TeacherDAO;
import net.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Service
public class TeacherServiceImpl {
    @Autowired
    private TeacherDAO teacherDAO;

    public void add(Teacher teacher) throws SQLException {
        this.teacherDAO.add(teacher);
    }

    public List<Teacher> getAll() throws SQLException {
        return this.teacherDAO.getAll();
    }

    public Teacher getById(int id) throws SQLException {
        return this.teacherDAO.getById(id);
    }

    public void update(Teacher teacher) throws SQLException {
        this.teacherDAO.update(teacher);
    }

    public void remove(int id) throws SQLException {
        this.teacherDAO.remove(id);
    }
}
