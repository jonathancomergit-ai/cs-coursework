//Jonathan Comer
//Homework 3 CS1100
//This program created triagle objects and then lets us find the area


public class Triangle
{
    //variables
    private double base;
    private double height;

    //no arg constructor
    Triangle()
    {
        this.base = 0.0;
        this.height = 0.0;
    }

    //arg constructor
    Triangle(double base, double height)
    {
        this.base = base;
        this.height = height;
    }

    //toString
    @Override
    public String toString() {
        return "base: " + base + ", height: " + height;
    }

    //Getters and setters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //get area method
    public double getArea() {
        return (this.base * this.height) / 2.0;
    }
}
