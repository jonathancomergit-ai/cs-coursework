//CS 1110
//Jonathan Comer
//This program constructs the time with 2 different approaches

public class Time
{
    //variables
    private int hour;
    private int minute;
    private int second;


    //no argument constructor
    public Time()
    {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    //Argument constructor
    public Time(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //toString builder
    public String toString()
    {
        return hour + ":" + minute + ":" + second;
    }

    //main
    public static void main(String[] args)
    {
        Time time1 = new Time();
        Time time2 = new Time(11, 11, 11);

        System.out.println("time1: " + time1);
        System.out.println("time2: " + time2);
    }
}
