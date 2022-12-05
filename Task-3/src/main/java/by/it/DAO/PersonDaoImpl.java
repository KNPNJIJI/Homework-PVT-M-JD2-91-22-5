package by.it.DAO;

import by.it.pojos.Person;
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
    public void create(Person person){
        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();
    };

    @Override
    public void delete(Person person){
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
    };
}
