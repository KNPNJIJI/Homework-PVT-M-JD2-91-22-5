package by.itacademy.service;

import by.itacademy.dao.EmployeeDao;
import by.itacademy.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional(transactionManager = "transactionManager")
    public void create(Employee employee) {
        employeeDao.create(employee);
    }

    @Transactional(transactionManager = "transactionManager")
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }

    public Employee findById(Integer id){
        return employeeDao.findById(id);
    }

    public List<Employee> findAll(){
        return employeeDao.findAll();
    }

    @Transactional(transactionManager = "transactionManager")
    public void update(Employee employee){
        employeeDao.update(employee);
    }
}
