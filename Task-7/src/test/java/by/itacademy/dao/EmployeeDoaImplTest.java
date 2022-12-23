package by.itacademy.dao;

import by.itacademy.model.Employee;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDoaImplTest {

    @Autowired
    EmployeeDao targetObject;

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    @Transactional
    public void create() {
        Employee employee = new Employee();
        employee.setFirstName("Misha");

        targetObject.create(employee);

        Employee employeeFind = new Employee();
        targetObject.findById(employeeFind.getId());
        assertEquals(employee.getFirstName(), employeeFind.getFirstName());
    }

    @Test
    public void delete() {
    }
}