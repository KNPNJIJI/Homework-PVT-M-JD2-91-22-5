package by.it.pojos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "EMPLOYEE")
@DiscriminatorValue(value ="S")
public class Student extends Person{
    private static final long serialVersionUID = 1L;
    private String faculty;
    private Double mark;
    public Student ( int age, String name, String faculty, Double mark) {
        super.setAge(age);
        super.setName(name);
        this.faculty = faculty;
        this.mark = mark;
    }
}
