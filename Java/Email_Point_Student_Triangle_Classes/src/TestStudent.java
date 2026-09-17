// TestStudent
// Add this file to your IntelliJ project.
// Do not modify this file.

public class TestStudent
{
    public static void main(String[] args)
    {
        System.out.println("Constructors");
        // Test the no arg constructor.
        Student s1 = new Student();

        // Test the other constructor.
        Student s2 = new Student("Jack", "Sparrow");

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        System.out.println();

        System.out.println("Getters and Setters");
        System.out.println("s1.getFirstName(): " + s1.getFirstName());
        System.out.println("s1.getLastName(): " + s1.getLastName());
        System.out.println("s1.getID(): " + s1.getID());
        s1.setFirstName("Darth");
        s1.setLastName("Vader");
        System.out.println("s1.getFirstName(): " + s1.getFirstName());
        System.out.println("s1.getLastName(): " + s1.getLastName());

    }
}
