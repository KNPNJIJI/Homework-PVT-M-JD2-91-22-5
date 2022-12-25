package by.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee")
    //@SequenceGenerator(name = "employee", sequenceName = "employee")
    private Integer id;

//    @Column(name = "BIRTH_DATE")
//    private Date birthDate;
//
//    @Column(name = "CELL_PHONE")
//    private String cellPhone;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;
}
