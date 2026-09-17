//CS 1110
//Jonathan Comer
//This program constructs the time with 2 different approaches

public class Movie
{
    //variables
    private String title;
    private int runningTime;
    private int releaseYear;

    //no argument constructor
    public Movie()
    {
        this.title = "The Matrix";
        this.runningTime = 136;
        this.releaseYear = 1999;
    }

    //Argument constructor
    public Movie(String title, int runningTime, int releaseYear)
    {
        this.title = title;
        this.runningTime = runningTime;
        this.releaseYear = releaseYear;
    }

    //toString method
    public String toString()
    {
        return title + " (" + releaseYear + ") (" +runningTime + ")";
    }

    //main
    public static void main(String[] args)
    {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie("Starwars", 121, 1977);

        System.out.println("movie1: " + movie1);
        System.out.println("movie2: " + movie2);
    }
}
