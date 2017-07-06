package net.service;


import net.dao.ClassUnitDAO;
import net.dao.ClassUnitImpl;
import net.model.ClassUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class ClassUnitServiceImpl implements ClassUnitService{

    private ClassUnitDAO classUnitDAO;

    public void setClassUnitDAO(ClassUnitDAO classUnitDAO) {
        this.classUnitDAO = classUnitDAO;
    }
    @org.springframework.transaction.annotation.Transactional
    public void add(ClassUnit classUnit)  {
        this.classUnitDAO.add(classUnit);
    }
    @org.springframework.transaction.annotation.Transactional
    public List<ClassUnit> getAll()  {
        return this.classUnitDAO.getAll();
    }
    @org.springframework.transaction.annotation.Transactional
    public ClassUnit getById(int id)  {
        return this.classUnitDAO.getById(id);
    }
    @org.springframework.transaction.annotation.Transactional
    public void update(ClassUnit classUnit)  {
            this.classUnitDAO.update(classUnit);
    }
        @org.springframework.transaction.annotation.Transactional
    public void remove(int id)  {
        this.classUnitDAO.remove(id);
    }


}
