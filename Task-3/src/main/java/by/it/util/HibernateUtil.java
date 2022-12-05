package by.it.util;

import by.it.pojos.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    public HibernateUtil() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            Metadata metadata = new MetadataSources( standardRegistry )
                    .addAnnotatedClass( Person.class )
                    .getMetadataBuilder()
                    .build();
            sessionFactory = metadata.getSessionFactoryBuilder()
                    .build();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static final EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("by.it");
    }

    public static EntityManager getEntityManager() {return entityManagerFactory.createEntityManager();}
    public static void close() { entityManagerFactory.close();}

    public static Session getSession() {return sessionFactory.openSession();}
}
