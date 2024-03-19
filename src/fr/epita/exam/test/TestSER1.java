// TestSER1.java
package fr.epita.exam.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TestSER1 {

    // Method to test reading the second line from a CSV file
    public static void test() {
        // Define the path to the CSV file.
        Path currentFilePath = Path.of("data/data.csv");
        System.out.println("Looking for file at this location: " + currentFilePath.toAbsolutePath());

        try {
            // Read all lines from the CSV file and store them in a list.
            List<String> lines = Files.readAllLines(currentFilePath);

            // Check if there are at least two lines in the file
            if (lines.size() >= 2) {
                // Display the second line in the console
                System.out.println("Second line of the file:");
                System.out.println(lines.get(1));
            } else {
                System.out.println("File does not contain enough lines.");
            }
        } catch (IOException e) {
            // Handle IOException if file reading fails
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
