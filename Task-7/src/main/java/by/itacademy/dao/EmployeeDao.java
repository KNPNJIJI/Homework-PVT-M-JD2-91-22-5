package by.itacademy.dao;

import by.itacademy.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void create(Employee employee);

    Employee findById(long id);

    void update(Employee employee);

    void delete(Employee employee);

    List<Employee> findAll();
}
