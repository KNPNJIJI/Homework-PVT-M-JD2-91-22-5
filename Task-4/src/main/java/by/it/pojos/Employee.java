package by.it.pojos;

import javax.persistence.*;

@Entity
//@Table(name = "EMPLOYEE")
@DiscriminatorValue(value ="E")
public class Employee  extends Person{
    private static final long serialVersionUID = 1L;
    private String company;
    private String salary;
}
