package by.it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Embeddable
public class Address {

    @Column
    private String city;
    @Column
    private String postCode;
    @Column
    private String address;
}
