package fr.epita.exam.test;

import fr.epita.exam.datamodel.Person;
import fr.epita.exam.services.PersonCSVDAO;
import fr.epita.exam.services.PersonJDBCDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TestJDB3 {

    public static void test() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb")) {
            // Create table
            TestJDB1.test();

            // Read persons from CSV
            PersonCSVDAO csvDAO = new PersonCSVDAO();
            List<Person> persons = csvDAO.readAll();

            // Insert into database
            PersonJDBCDAO jdbcDAO = new PersonJDBCDAO(connection);
            for (Person person : persons) {
                jdbcDAO.create(person);
            }

            // Validate insertion
            List<Person> retrievedPersons = jdbcDAO.search();
            System.out.println("Persons in the database:");
            for (Person retrievedPerson : retrievedPersons) {
                System.out.println(retrievedPerson);
            }

            // Update a person
            Person personToUpdate = retrievedPersons.get(0);
            personToUpdate.setPersonAge(30); // Updating age
            personToUpdate.setPersonHeight(72.5); // Updating height
            jdbcDAO.update(personToUpdate);

            // Delete a person
            Person personToDelete = retrievedPersons.get(1);
            jdbcDAO.delete(personToDelete.getPersonName());

            // Validate update and deletion
            retrievedPersons = jdbcDAO.search();
            System.out.println("Persons after update and delete:");
            for (Person retrievedPerson : retrievedPersons) {
                System.out.println(retrievedPerson);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
