package academy.beans;

import academy.pojos.Address;
import academy.pojos.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
    @Test
    public void testCreatePerson() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Person p1 = context.getBean("person", Person.class);
        Person p2 = context.getBean("person", Person.class);

        System.out.println("person bean: " + p1);
        System.out.println("person bean: " + p2);
        System.out.println("Address bean: " + p1.getAddress());

        context.close();
    }

}
