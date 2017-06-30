package net.service;


import net.dao.ClassUnitDAO;
import net.model.ClassUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Service
public class ClassUnitServiceImpl implements ClassUnitService{
    @Autowired
    private ClassUnitDAO classUnitDAO;

    public void add(ClassUnit classUnit) throws SQLException {
        this.classUnitDAO.add(classUnit);
    }

    public List<ClassUnit> getAll() throws SQLException {
        return this.classUnitDAO.getAll();
    }

    public ClassUnit getById(int id) throws SQLException {
        return this.classUnitDAO.getById(id);
    }

    public void update(ClassUnit classUnit) throws SQLException {
            this.classUnitDAO.update(classUnit);
    }

    public void remove(int id) throws SQLException {
        this.classUnitDAO.remove(id);
    }
}
