package academy.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements IAddress {
    private Long id;
    private String street;
    private String city;
    private String country;
    private String email;

}
