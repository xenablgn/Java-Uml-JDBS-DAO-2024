package fr.epita.exam.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDB1 {

    /**
     * Test method to create a table named PERSONS in an H2 in-memory database.
     * The table has columns for ID (auto-increment primary key), NAME, SEX, AGE, HEIGHT, and WEIGHT.
     */
    public static void test() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE PERSONS (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL," +
                    "SEX CHAR(1)," +
                    "AGE INT," +
                    "HEIGHT DOUBLE," +
                    "WEIGHT DOUBLE" +
                    ")";
            statement.executeUpdate(createTableQuery);
            System.out.println("Table PERSONS created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
