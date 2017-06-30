package net.dao;


import net.model.ClassUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.postgresql.core.NativeQuery;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.List;

@Repository
public class ClassUnitImpl implements ClassUnitDAO {

    private SessionFactory sessionFactory;
    public void SetSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(ClassUnit classUnit) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(classUnit);
    }

    public List<ClassUnit> getAll() throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        List<ClassUnit> classUnits = session.createQuery("from ClassUnit").list();

        return classUnits;
    }

    public ClassUnit getById(int id) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        ClassUnit classUnit = (ClassUnit) session.load(ClassUnit.class,new Integer(id));

        return classUnit;
    }

    public void update(ClassUnit classUnit) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
            session.update(classUnit);
    }

    public void remove(int id) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        ClassUnit classUnit = (ClassUnit) session.load(ClassUnit.class, new Integer(id));
        if(classUnit!=null){
            session.delete(classUnit);
        }
    }
}
