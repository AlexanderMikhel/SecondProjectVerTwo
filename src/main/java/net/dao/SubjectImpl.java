package net.dao;

import net.model.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SubjectImpl implements SubjectDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void add(Subject subject){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(subject);
    }

    public List<Subject> getAll()  {
        Session session = this.sessionFactory.getCurrentSession();
        List<Subject> subjects = session.createQuery("from Subject").list();

        return subjects;
    }

    public Subject getById(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Subject subject = (Subject) session.load(Subject.class,new Integer(id));

        return subject;
    }

    public void update(Subject subject){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(subject);
    }

    public void remove(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Subject subject = (Subject) session.load(Subject.class, new Integer(id));
        if(subject!=null){
            session.delete(subject);
        }
    }
}
