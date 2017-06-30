package net.dao;

import net.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherImpl implements TeacherDAO{
    private SessionFactory sessionFactory;
    public void SetSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(Teacher teacher) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(teacher);
    }

    public List<Teacher> getAll() throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        List<Teacher> teachers = session.createQuery("from Teacher").list();

        return teachers;
    }

    public Teacher getById(int id) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        Teacher teacher = (Teacher) session.load(Teacher.class,new Integer(id));

        return teacher;
    }

    public void update(Teacher teacher) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(teacher);
    }

    public void remove(int id) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));
        if(teacher!=null){
            session.delete(teacher);
        }
    }
}
