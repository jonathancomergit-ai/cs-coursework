// TestPoint
// Add this file to your IntelliJ project.
// Do not modify this file.

public class TestPoint
{
    public static void main(String[] args)
    {
        System.out.println("Constructors");
        // Test the no arg constructor.
        Point p1 = new Point();
        System.out.println("p1: " + p1);

        // Test the other constructor.
        Point p2 = new Point(1.0, 1.0);
        Point p3 = new Point(5.0, 0.0);
        Point p4 = new Point(1.0, 2.0);

        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);

        System.out.println();

        // Check the format of the toString() method.
        System.out.println("toString() Method");
        System.out.println("Correct format? " + p1.toString().equals("(0.0, 0.0)"));

        System.out.println();

        System.out.println("Getters and Setters");
        System.out.println("p4.getX(): " + p4.getX());
        System.out.println("p4.getY(): " + p4.getY());
        p4.setX(3.567);
        p4.setY(4.123);
        System.out.println("p4.getX(): " + p4.getX());
        System.out.println("p4.getY(): " + p4.getY());

        System.out.println();

        // Test the distance() method.
        System.out.println("distance() Method");
        System.out.println("p1 to p2: " + p1.distance(p2));
        System.out.println("p1 to p3: " + p1.distance(p3));
        System.out.println("p1 to p4: " + p1.distance(p4));
    }
}
