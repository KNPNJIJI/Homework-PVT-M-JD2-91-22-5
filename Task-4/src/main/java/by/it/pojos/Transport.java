package by.it.pojos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRANSPORT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Transport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Double weight;
}
