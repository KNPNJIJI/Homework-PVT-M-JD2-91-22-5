package by.it.pojos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CAR")
public class Car extends Transport{
    private static final long serialVersionUID = 1L;
    private int passengerCapacity;
    private boolean hitch;
}
