// TestSER2.java
package fr.epita.exam.test;

import fr.epita.exam.services.PersonCSVDAO;
import fr.epita.exam.datamodel.Person;

import java.util.List;

public class TestSER2 {

    // Method to test reading all persons from a CSV file and displaying them
    public static void test() {
        // Create an instance of PersonCSVDAO
        PersonCSVDAO dao = new PersonCSVDAO();
        // Invoke the readAll() method to get the list of persons sorted by height
        List<Person> persons = dao.readAll();
        // Display the list of persons in the console
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
