//CS 1110
//Jonathan Comer
//This program constructs the time with 2 different approaches

public class Date
{
    //variables
    private int year;
    private int month;
    private int day;

    //No argument constructor
    public Date()
    {
        this.year = 2000;
        this.month = 1;
        this.day = 1;
    }

    //Argument constructor
    public Date(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //toString builder
    public String toString()
    {
        return year + "-" + month + "-" + day;
    }

    //main
    public static void main(String[] args)
    {
        Date date1 = new Date();
        Date date2 = new Date(2018, 2, 1);

        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
    }
}
