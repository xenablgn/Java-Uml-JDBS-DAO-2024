package fr.epita.exam.services;

import fr.epita.exam.datamodel.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonJDBCDAO {

    private final Connection connection;

    // Constructor
    public PersonJDBCDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to insert a new person into the database
    public void create(Person person) {
        // SQL query to insert a new person
        String insertQuery = "INSERT INTO PERSONS (NAME, SEX, AGE, HEIGHT, WEIGHT) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // Set values for the prepared statement
            preparedStatement.setString(1, person.getPersonName()); // Name
            preparedStatement.setString(2, person.getPersonSex().substring(0, 1)); // Sex (first character only)
            preparedStatement.setInt(3, person.getPersonAge()); // Age
            preparedStatement.setDouble(4, person.getPersonHeight()); // Height
            preparedStatement.setDouble(5, person.getPersonWeight()); // Weight

            // Execute the insert statement
            preparedStatement.executeUpdate();
            // Print confirmation message
            System.out.println("Inserted person: " + person);
        } catch (SQLException e) {
            // Handle any errors that occur during the insertion
            System.out.println("Error inserting person: " + e.getMessage());
        }
    }

    // Method to search for all persons in the database
    public List<Person> search() {
        List<Person> persons = new ArrayList<>();
        // SQL query to select all persons
        String selectQuery = "SELECT * FROM PERSONS";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = statement.executeQuery()) {
            // Iterate over the result set and create Person objects
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String sex = resultSet.getString("SEX").trim();
                int age = resultSet.getInt("AGE");
                double height = resultSet.getDouble("HEIGHT");
                double weight = resultSet.getDouble("WEIGHT");

                // Create a Person object and add it to the list
                Person person = new Person(name, sex, age, height, weight);
                persons.add(person);
            }
        } catch (SQLException e) {
            // Handle any errors that occur during the search
            System.out.println("Error searching for persons: " + e.getMessage());
        }
        return persons; // Return the list of persons found
    }

    // Method to update a person in the database
    public void update(Person person) {
        // SQL query to update a person
        String updateQuery = "UPDATE PERSONS SET NAME=?, SEX=?, AGE=?, HEIGHT=?, WEIGHT=? WHERE NAME=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            // Set values for the prepared statement
            preparedStatement.setString(1, person.getPersonName()); // Name
            preparedStatement.setString(2, person.getPersonSex().substring(0, 1)); // Sex (first character only)
            preparedStatement.setInt(3, person.getPersonAge()); // Age
            preparedStatement.setDouble(4, person.getPersonHeight()); // Height
            preparedStatement.setDouble(5, person.getPersonWeight()); // Weight
            preparedStatement.setString(6, person.getPersonName()); // Search by name

            // Execute the update statement
            preparedStatement.executeUpdate();
            // Print confirmation message
            System.out.println("Updated person: " + person);
        } catch (SQLException e) {
            // Handle any errors that occur during the update
            System.out.println("Error updating person: " + e.getMessage());
        }
    }

    // Method to delete a person from the database
    public void delete(String name) {
        // SQL query to delete a person
        String deleteQuery = "DELETE FROM PERSONS WHERE NAME=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            // Set the person name for the prepared statement
            preparedStatement.setString(1, name);

            // Execute the delete statement
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Print confirmation message if deletion was successful
                System.out.println("Deleted person with name " + name);
            } else {
                // Print message if no person with the specified name was found
                System.out.println("No person found with name " + name);
            }
        } catch (SQLException e) {
            // Handle any errors that occur during the deletion
            System.out.println("Error deleting person: " + e.getMessage());
        }
    }
}
