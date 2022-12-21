package academy.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address1 implements IAddress{
    private Long id;
    private String street;
    private String city;
}
