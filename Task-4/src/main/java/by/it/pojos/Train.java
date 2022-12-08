package by.it.pojos;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRAIN")
public class Train extends Transport{
    private int numberTrainCars;
    private boolean electric;
}
