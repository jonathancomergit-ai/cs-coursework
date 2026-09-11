//Jonathan Comer
//Homework 3 CS1100
//This program Creates 2 points then find the distance between them. It is then checked with the teachers program


public class Point
{
    //variables
    private double x;
    private double y;

    //no arg constructor
    public Point()
    {
        this.x = 0.0;
        this.y = 0.0;
    }

    //arg constructor
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    //toString
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    //Getters and setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //distance Method
    public double distance(Point point2)
    {
        double xdiff = this.x - point2.x;
        double ydiff = this.y - point2.y;

        return Math.sqrt((xdiff*xdiff) + (ydiff * ydiff));
    }
}
