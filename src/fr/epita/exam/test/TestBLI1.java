package fr.epita.exam.test;

import fr.epita.exam.datamodel.Person;
import fr.epita.exam.services.PersonCSVDAO;
import fr.epita.exam.services.PersonDataService;

import java.util.List;

public class TestBLI1 {

    public static void test() {
        // Create an instance of PersonCSVDAO to read persons from the CSV file
        PersonCSVDAO csvDAO = new PersonCSVDAO();
        List<Person> persons = csvDAO.readAll(); // Read all persons from the CSV file

        PersonDataService service = new PersonDataService();

        // Call averageAge function
        int avgAge = service.averageAge(persons);
        System.out.println("Average Age: " + avgAge);

        // Call filter function
        int threshold = 32;
        List<Person> filteredList = service.filter(persons, threshold);
        System.out.println("Number of Persons above " + threshold + " years old: " + filteredList.size());

        // Call calculateYearOfBirth on the 1st person in the list
        if (!persons.isEmpty()) {
            Person firstPerson = persons.get(0);
            int yearOfBirth = service.calculateYearOfBirth(firstPerson);
            System.out.println("Year of Birth for " + firstPerson.getPersonName() + ": " + yearOfBirth);
        } else {
            System.out.println("No persons available to calculate the year of birth.");
        }
    }
}
