package fr.epita.exam.test;

import fr.epita.exam.datamodel.Person;
import fr.epita.exam.services.PersonCSVDAO;
import java.util.List;

public class TestSER3 {

    // Method to test writing all persons from a list to a CSV file
    public static void test() {
        // Create an instance of PersonCSVDAO
        PersonCSVDAO dao = new PersonCSVDAO();
        // Read all persons from the CSV file
        List<Person> persons = dao.readAll();
        // Write all persons to a new CSV file
        dao.writeAll(persons);
    }
}
