package net.dao;

import net.model.Mark;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MarkImpl implements MarkDAO {

    private SessionFactory sessionFactory;



    public void add(Mark mark)  {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(mark);
    }

    public List<Mark> getAll(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Mark> marks = session.createQuery("from Mark").list();

        return marks;
    }

    public Mark getById(int id){
        Session session = this.sessionFactory.getCurrentSession();
        /*
        Mark mark = (Mark) session.load(Mark.class,new Integer(id));
        */
        Mark mark = (Mark) session.get(Mark.class,id);
        return mark;
    }

    public void update(Mark mark) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(mark);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Mark mark = (Mark) session.load(Mark.class, new Integer(id));
        if(mark!=null){
            session.delete(mark);
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
