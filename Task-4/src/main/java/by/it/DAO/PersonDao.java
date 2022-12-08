package by.it.DAO;

import by.it.pojos.Person;

public interface PersonDao {
    Person findById(int id);
    void createPerson(Person person);
    void delete(Person person);
}
