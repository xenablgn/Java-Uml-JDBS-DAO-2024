package fr.epita.exam.services;

import fr.epita.exam.datamodel.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonCSVDAO {

    // Method to read all persons from a CSV file
    public List<Person> readAll() {
        List<Person> persons = new ArrayList<>();
        // Define the path to the CSV file.
        Path currentFilePath = Path.of("data/data.csv");
        System.out.println("Looking for file at this location: " + currentFilePath.toAbsolutePath());
        try {
            // Read all lines from the CSV file
            List<String> lines = Files.readAllLines(currentFilePath);

            // Remove the header line
            lines.remove(0);

            // Iterate over each line
            for (String line : lines) {
                String[] parts = line.split(","); // Splitting the line by comma to get person attributes
                Person person = extractPerson(parts); // Extracting person information
                persons.add(person); // Adding person object to the list
            }

            // Sort the list by height using a Comparator
            persons.sort(Comparator.comparingDouble(Person::getPersonHeight));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return persons; // Returning the list of persons sorted by height
    }

    // Helper method to extract person information from an array of strings
    private static Person extractPerson(String[] row) {
        // Extracting person information from the input array
        String name = row[0].trim();
        String sex = row[1].trim();
        int age = Integer.parseInt(row[2].trim());
        double height = Double.parseDouble(row[3].trim());
        double weight = Double.parseDouble(row[4].trim());
        // Creating and returning the person object with the extracted information
        return new Person(name, sex, age, height, weight);
    }

    // Method to write all persons to an output CSV file
    public void writeAll(List<Person> persons) {
        // Define the path to the output CSV file in the same directory as the input file.
        String fileName = "data/data_output.csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write headers
            writer.append("Name,Height (in),Weight (lbs),Age,Sex\n");

            // Write each person's information
            for (Person person : persons) {
                writer.append(person.getPersonName()).append(",");
                writer.append(String.valueOf(person.getPersonHeight())).append(",");
                writer.append(String.valueOf(person.getPersonWeight())).append(",");
                writer.append(String.valueOf(person.getPersonAge())).append(",");
                writer.append(person.getPersonSex()).append("\n");
            }
            System.out.println("Data has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }
}
