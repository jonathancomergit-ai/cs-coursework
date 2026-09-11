// TestTriangle
// Add this file to your IntelliJ project.
// Do not modify this file.

public class TestTriangle
{
    public static void main(String[] args)
    {
        System.out.println("Constructors");
        // Test the no arg constructor.
        Triangle t1 = new Triangle();

        // Test the other constructor.
        Triangle t2 = new Triangle(5.0, 10.0);

        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);

        System.out.println();

        // Check the format of the toString() method.
        System.out.println("toString() Method");
        System.out.println("Correct format? " + t1.toString().equals("base: 0.0, height: 0.0"));

        System.out.println();

        System.out.println("Getters and Setters");
        System.out.println("t1.getBase(): " + t1.getBase());
        System.out.println("t1.getHeight(): " + t1.getHeight());
        t1.setBase(14.0);
        t1.setHeight(7.0);
        System.out.println("t1.getBase(): " + t1.getBase());
        System.out.println("t1.getHeight(): " + t1.getHeight());

        System.out.println();

        // Test the getArea() method.
        System.out.println("getArea() Method");
        System.out.println("t1.getArea(): " + t1.getArea());
        System.out.println("t2.getArea(): " + t2.getArea());
    }
}
