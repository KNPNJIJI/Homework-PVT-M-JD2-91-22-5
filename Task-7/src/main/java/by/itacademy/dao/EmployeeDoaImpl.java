package by.itacademy.dao;

import by.itacademy.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDoaImpl implements EmployeeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Employee employee){
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    };

    @Override
    public Employee findById(Integer id){
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    };

    @Override
    public void update(Employee employee){
        create(employee);
    };

    @Override
    public void delete(Employee employee){
        Employee loadedEmployee = sessionFactory.getCurrentSession().load(Employee.class, employee.getId());
        sessionFactory.getCurrentSession().delete(loadedEmployee);
    };

    @Override
    public List<Employee> findAll(){
        return sessionFactory.getCurrentSession().createQuery("from Employee", Employee.class).list();
    };
}
