package academy.pojos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Person {
    private Integer id;
    private String name;
    private String surname;

    @Autowired
    @Qualifier("address1")
    private IAddress address;

    public static Person getPerson(){
        System.out.println("factory-method getPerson");
        return new Person();
    }
    public void init(){
        System.out.println("Call init() " + name );
    }

    public void destroy(){
        System.out.println("Call destroy() "+ name );
    }
}
