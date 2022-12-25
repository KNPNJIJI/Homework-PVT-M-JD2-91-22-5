package by.itacademy.service;

import by.itacademy.dao.EmployeeDoaImpl;
import by.itacademy.model.Employee;
import by.itacademy.util.DataConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class EmployeeServiceTest {

    @Test
    public void create() {
        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(
                DataConfig.class,
                EmployeeDoaImpl.class,
                EmployeeService.class);
        EmployeeService service = annotationContext.getBean("employeeService", EmployeeService.class);

        Employee employee = new Employee(null, "Misha", "Petrov");

        service.create(employee);
        System.out.println("findEmployee: " + employee.getFirstName() + " " + employee.getId());

        Employee employeeFind = service.findById(employee.getId());
        assertEquals(employee.getFirstName(), employeeFind.getFirstName());
    }

    @Test
    public void delete() {
        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(
                DataConfig.class,
                EmployeeDoaImpl.class,
                EmployeeService.class);
        EmployeeService service = annotationContext.getBean("employeeService", EmployeeService.class);

        Employee employee = new Employee(null, "Misha", "Petrov");

        service.create(employee);
        service.delete(employee);
        Employee employeeFind = service.findById(employee.getId());
        assertNull(employeeFind);
    }
}