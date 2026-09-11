//Jonathan Comer
//Homework 3 CS1100
//This program creates student profiles and randomly generates student ids

import java.util.Random;

public class Student
{
    //varibles
    private String firstName;
    private String lastName;
    private int id;

    //student no args constuctor
    Student() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.id = 700000000 + new Random().nextInt(1000000);
    }

    //args constructor
    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = 700000000 + new Random().nextInt(1000000);
    }

    //toString
    @Override
    public String toString() {
        return lastName + ", " + firstName + " (" +id + ")";
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID()
    {
        return id;
    }

}
