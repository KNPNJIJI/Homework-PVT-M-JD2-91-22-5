package by.it.DAO;

import by.it.pojos.*;
import org.hibernate.Session;

public class PersonDaoImpl implements PersonDao{

    private final Session session;
    public PersonDaoImpl(Session session){
        this.session = session;
    }

    @Override
    public Person findById(int id){
        return session.get(Person.class, id);
    };

    @Override
    public void createPerson(Person person){
        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();
    };

    public void createStudent(Student student){
        session.beginTransaction();
        session.saveOrUpdate(student);
        session.getTransaction().commit();
    };

    public void createFigure(Figure figure){
        session.beginTransaction();
        session.saveOrUpdate(figure);
        session.getTransaction().commit();
    };

    public void createFigure3D(Figure3D figure3D){
        session.beginTransaction();
        session.saveOrUpdate(figure3D);
        session.getTransaction().commit();
    };

    public void createTransport(Transport transport){
        session.beginTransaction();
        session.saveOrUpdate(transport);
        session.getTransaction().commit();
    };

    public void createCar(Car car){
        session.beginTransaction();
        session.saveOrUpdate(car);
        session.getTransaction().commit();
    };

    public void createTrain(Train train){
        session.beginTransaction();
        session.saveOrUpdate(train);
        session.getTransaction().commit();
    };

    @Override
    public void delete(Person person){
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
    };

    public void createAccount(Account account){
        session.beginTransaction();
        session.saveOrUpdate(account);
        session.getTransaction().commit();
    };

}
