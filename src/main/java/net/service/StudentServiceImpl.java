package net.service;


import net.dao.StudentDAO;
import net.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDAO studentDAO;

    public void add(Student student) throws SQLException {
        this.studentDAO.add(student);
    }

    public List<Student> getAll() throws SQLException {
        return this.studentDAO.getAll();
    }

    public Student getById(int id) throws SQLException {
        return this.studentDAO.getById(id);
    }

    public void update(Student student) throws SQLException {
        this.studentDAO.update(student);
    }

    public void remove(int id) throws SQLException {
        this.studentDAO.remove(id);
    }
}
