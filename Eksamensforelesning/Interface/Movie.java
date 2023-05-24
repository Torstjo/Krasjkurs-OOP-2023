package Eksamensforelesning.Interface;

import java.util.ArrayList;
import java.util.Collections;

class Movie implements Comparable<Movie>
{
    private int rating;
    private String name;
    private int year;

    // Constructor
    public Movie(String nm, int rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }
 
    // Used to sort movies by year
    public int compareTo(Movie movie)
    {
        return this.rating - movie.rating;
    }
 
    // Getter methods for accessing private data
    public int getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }
}
 
class Main
{
    public static void main(String[] args)
    {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 6, 2015));
        list.add(new Movie("Star Wars", 7, 1977));
        list.add(new Movie("Empire Strikes Back", 10, 1980));
        list.add(new Movie("Return of the Jedi", 7, 1983));

        System.out.println("Filmer før sortering: ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                               movie.getRating() + " " +
                               movie.getYear());
        }

        System.out.println();
 
        Collections.sort(list);
 
        System.out.println("Filmer etter sortering: ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                               movie.getRating() + " " +
                               movie.getYear());
        }
    }

}