package by.it.loader;

import by.it.DAO.PersonDaoImpl;
import by.it.pojos.Address;
import by.it.pojos.Person;
import by.it.util.HibernateUtilTest;
import by.it.util.JdbcUtilTest;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PersonLoaderTest {

    HibernateUtilTest hibernateUtil = new HibernateUtilTest();
    private final Session session = hibernateUtil.getSession();

    static JdbcUtilTest jdbcUtilTest = new JdbcUtilTest();

    PersonDaoImpl targetObject;

    @Before
    public void setUp() throws Exception {
        targetObject = new PersonDaoImpl(session);
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        Address address = new Address("Minsk", "123456", "Semashko");
        Person person = new Person(null, 24, "John", "Smith", address);
        targetObject.createPerson(person);

        //When
        Person findPerson = targetObject.findById(person.getId());

        //Then
        assertEquals(findPerson.getId(), person.getId());
    }

    @Test
    @SneakyThrows
    public void create() {
        //Given
        Connection conn = jdbcUtilTest.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from person;");
        rs.next();
        int initialSize = rs.getInt(1);

        //When
        Address address = new Address("Minsk", "123456", "Semashko");
        Person person = new Person(null, 22, "Mary", "White", address);
        targetObject.createPerson(person);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from person;");
        rs.next();
        int countAfterInsert = rs.getInt(1);
        assertEquals(initialSize + 1, countAfterInsert);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        Connection conn = jdbcUtilTest.getConnection();
        Address address = new Address("Minsk", "123456", "Semashko");
        Person person = new Person(null, 22, "Mary", "White", address);
        targetObject.createPerson(person);
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from person;");
        rs.next();
        int initialSize = rs.getInt(1);

        //When
        targetObject.delete(person);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from person;");
        rs.next();
        int countAfterInsert = rs.getInt(1);
        assertEquals(initialSize - 1, countAfterInsert);
    }
}