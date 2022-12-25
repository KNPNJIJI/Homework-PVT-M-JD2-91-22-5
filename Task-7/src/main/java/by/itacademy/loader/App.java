package by.itacademy.loader;

import by.itacademy.dao.EmployeeDoaImpl;
import by.itacademy.model.Employee;
import by.itacademy.service.EmployeeService;
import by.itacademy.util.DataConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{

    public static void main( String[] args ) {
        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(
                DataConfig.class,
                EmployeeDoaImpl.class,
                EmployeeService.class);
        EmployeeService service = annotationContext.getBean("employeeService", EmployeeService.class);

        Employee employee = new Employee(null, "Misha", "Petrov");

        service.create(employee);
        System.out.println("findEmployee: " + employee.getFirstName() + " " + employee.getId());
        Employee findEmployee = service.findById(employee.getId());
        System.out.println("findEmployee: " + findEmployee.getFirstName() + " " + findEmployee.getId());

    }
}
