package by.it.util;

import by.it.pojos.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import static org.junit.Assert.*;

public class HibernateUtilTest {

    static SessionFactory testSessionFactory;
    public HibernateUtilTest() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate_test.cfg.xml")
                    .build();
            Metadata metadata = new MetadataSources( standardRegistry )
                    .addAnnotatedClass( Person.class )
                    .getMetadataBuilder()
                    .build();
            testSessionFactory = metadata.getSessionFactoryBuilder()
                    .build();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {return testSessionFactory.openSession();}
}