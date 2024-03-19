package fr.epita.exam.services;

import fr.epita.exam.datamodel.Person;

import java.time.LocalDate;
import java.util.List;

public class PersonDataService {

    // Method to calculate the mean age of the persons list
    public int averageAge(List<Person> persons) {
        if (persons.isEmpty()) {
            return 0; // Return 0 if the list is empty to avoid division by zero
        }

        int totalAge = 0;
        // Calculate the sum of ages
        for (Person person : persons) {
            totalAge += person.getPersonAge();
        }

        // Calculate the average age
        return totalAge / persons.size();
    }

    // Method to filter the list of persons above a given threshold age
    public List<Person> filter(List<Person> persons, int thresholdAge) {
        // Filter persons based on the given threshold age
        return persons.stream()
                .filter(person -> person.getPersonAge() > thresholdAge)
                .toList();
    }

    // Method to calculate the birth year of a given person
    public int calculateYearOfBirth(Person person) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        // Calculate the birth year by subtracting the person's age from the current year
        return currentYear - person.getPersonAge();
    }
}
