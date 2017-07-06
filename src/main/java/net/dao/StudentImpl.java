package net.dao;


import net.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentImpl implements StudentDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void add(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(student);
    }

    public List<Student> getAll()  {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from Student").list();

        return students;
    }

        public Student getById(int id)  {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class,new Integer(id));

        return student;
    }

    public void update(Student student){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(id));
        if(student!=null){
            session.delete(student);
        }
    }
}
