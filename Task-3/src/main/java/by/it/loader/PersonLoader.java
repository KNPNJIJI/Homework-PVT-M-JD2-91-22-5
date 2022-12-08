package by.it.loader;

import by.it.DAO.PersonDaoImpl;
import by.it.pojos.Person;
import by.it.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public class PersonLoader {

    static HibernateUtil hibernateUtil = new HibernateUtil();
    private static final Session session = hibernateUtil.getSession();

    public static void main( String[] args ) throws Exception {
        Person john = new Person(null, 35, "John", "Smith");
        EntityManager em = HibernateUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(john);
        em.getTransaction().commit();
        System.out.println("John's age " + john.getAge());

        em.refresh(john);
        System.out.println("John's age in table " + john.getAge());
        HibernateUtil.close();

        Person mary = new Person(null, 22, "Mary", "Pers");
        PersonDaoImpl personDaoImpl = new PersonDaoImpl(session);
        personDaoImpl.create(mary);
        //session.close();
        //personDaoImpl.createAndDelete(mary); // практическое create And Delete
        //mary = personDaoImpl.findById(101); // практическое get/load
        System.out.println("Mary's age " + mary.getAge());
    }


}
