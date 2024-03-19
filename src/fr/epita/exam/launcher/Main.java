package fr.epita.exam.launcher;

import fr.epita.exam.datamodel.Person;
import fr.epita.exam.test.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Print a welcome message
        System.out.println("Hello and welcome!");

        // Using try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter person's details
            System.out.println("Type a person's name:");
            String name = scanner.nextLine();

            System.out.println("Type person's sex:");
            String sex = scanner.nextLine();

            System.out.println("Type person's age:");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.println("Type person's height:");
            double height = Double.parseDouble(scanner.nextLine());

            System.out.println("Type person's weight:");
            double weight = Double.parseDouble(scanner.nextLine());

            // Create a Person object with the entered details
            Person person = new Person(name, sex, age, height, weight);
            // Display the details of the person
            System.out.println(person);

            // Execute the TestDMO2
            // Perform the test by invoking the test method from TestDMO2 class
            System.out.println("\nTesting TestDMO2:");
            TestDMO2.test();

            // Execute the TestSER1
            System.out.println("Executing TestSER1:");
            TestSER1.test();

            // Execute the TestSER2
            System.out.println("Executing TestSER2:");
            // Execute the test method from TestSER2
            TestSER2.test();

            System.out.println("Executing TestSER3:");
            // Execute TestSER3
            TestSER3.test();

            // Execute TestBLI1
            // Create a list of Person objects
            // List<Person> persons = new ArrayList<>();
            // persons.add(new Person("Sena", "M", 41, 74, 170));
            //  persons.add(new Person("Marcus", "M", 42, 68, 166));
            // Add more persons as needed
            // Invoke the test() method from TestBLI1 class
            System.out.println("Executing TestBLI1 :");
            TestBLI1.test();


            System.out.println("Executing TestJDB1  :");
            // Execute TestJDB1 to create the table
            TestJDB1.test();


            System.out.println("Executing TestJDB2 :");
            // Execute TestJDB2 to insert data into the table
            TestJDB2.test();


            System.out.println("Executing TestJDB3 :");
            // Execute TestJDB3 to insert data into the table
            TestJDB3.test();



        }
    }
}
