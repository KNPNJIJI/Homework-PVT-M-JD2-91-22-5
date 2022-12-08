package by.it.loader;

import by.it.DAO.PersonDaoImpl;
import by.it.pojos.*;
import by.it.util.HibernateUtil;
import org.hibernate.Session;
import java.util.Date;

import javax.persistence.EntityManager;

public class PersonLoader {

    static HibernateUtil hibernateUtil = new HibernateUtil();
    private static final Session session = hibernateUtil.getSession();

    public static void main( String[] args ) throws Exception {

        PersonDaoImpl personDaoImpl = new PersonDaoImpl(session);

        Address address = new Address("Minsk", "123456", "Semashko");
        Person mary = new Person(null, 22, "Mary", "Pers", address);
        Student john = new Student( 18, "John", "POIT", 7.7);
        Account account = new Account(null, "John", " Smith", new Date());

        personDaoImpl.createPerson(mary);
        personDaoImpl.createStudent(john);
        personDaoImpl.createAccount(account);
        System.out.println("Mary's id " + mary.getId() + "; account id " + account.getId());

        Figure figure = new Figure(null, 10.1,3.3);
        Figure3D figure3D = new Figure3D(20.2);
        personDaoImpl.createFigure(figure);
        personDaoImpl.createFigure3D(figure3D);

        Car car = new Car( 5, true);
        Train train = new Train(9, true);
        Transport transport = new Transport(null,3543.2);
        personDaoImpl.createTransport(transport);
        personDaoImpl.createCar(car);
        personDaoImpl.createTrain(train);

    }


}
