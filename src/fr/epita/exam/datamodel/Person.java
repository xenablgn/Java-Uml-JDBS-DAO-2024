package fr.epita.exam.datamodel;

public class Person {

    private String personName;
    private String personSex;
    private int personAge;
    private double personHeight;
    private double personWeight;

    public Person(String name, String sex, int age, double height, double weight) {
        // Initialize the attributes with the provided values
        this.personName = name;
        this.personSex = sex;
        this.personAge = age;
        this.personHeight = height;
        this.personWeight = weight;
    }


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public double getPersonHeight() {
        return personHeight;
    }

    public void setPersonHeight(double personHeight) {
        this.personHeight = personHeight;
    }

    public double getPersonWeight() {
        return personWeight;
    }

    public void setPersonWeight(double personWeight) {
        this.personWeight = personWeight;
    }

    @Override
    public String toString() {
        return "Person = [" +
                "personName='" + personName + '\'' +
                ", personSex='" + personSex + '\'' +
                ", personAge=" + personAge +
                ", personHeight=" + personHeight +
                ", personWeight=" + personWeight +
                ']';
    }
}
