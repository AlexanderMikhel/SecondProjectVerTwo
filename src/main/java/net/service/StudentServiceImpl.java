package net.service;


import net.dao.StudentDAO;
import net.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    @Transactional
    public void add(Student student)  {
        this.studentDAO.add(student);
    }
    @Transactional
    public List<Student> getAll()  {
        return this.studentDAO.getAll();
    }
    @Transactional
    public Student getById(int id)  {
        return this.studentDAO.getById(id);
    }
    @Transactional
    public void update(Student student)  {
        this.studentDAO.update(student);
    }
    @Transactional
    public void remove(int id)  {
        this.studentDAO.remove(id);
    }
}
