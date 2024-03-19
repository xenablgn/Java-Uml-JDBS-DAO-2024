package fr.epita.exam.test;

import fr.epita.exam.datamodel.Person;

public class TestDMO2 {

    // Method to test the Person class functionality
    public static void test() {
        // Creating an instance of Person with sample data
        Person person = new Person("Alex", "M", 30, 175.5, 150);
        // Printing the details of the person
        System.out.println("Name: " + person.getPersonName());
        System.out.println("Sex: " + person.getPersonSex());
        System.out.println("Age: " + person.getPersonAge());
        System.out.println("Height: " + person.getPersonHeight());
        System.out.println("Weight: " + person.getPersonWeight());
    }
}
