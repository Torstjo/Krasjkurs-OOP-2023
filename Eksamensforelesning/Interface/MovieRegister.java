package Eksamensforelesning.Interface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieRegister {
    // Add internal variables
	private Collection<MovieKont20> db = new ArrayList<>();
	
	/**
	 * Add movie to register
	 * @param movie
	 */
	public void addMovie(MovieKont20 movie) {
		db.add(movie);
	}
		
	/**
	 * 
	 * @param title
	 * @return the movie with matching title, or null if no such movie exists.
	 */
	MovieKont20 findMovie(String title) {
		return db.stream().filter(movie -> movie.getTitle().equals(title)).findFirst().orElse(null);
	}
	
	/**
	 * Filter all registered movies based on a Predicate, and return them as a Collection.
	 * @param pred is the filter for which movies to watch
	 * @return A collection of movies testing true to pred.
	 */
	Collection<MovieKont20> filterMovies(Predicate<MovieKont20> pred) {
		return db.stream().filter(pred).collect(Collectors.toList()); // dummy return value
	}
	
	/**
	 * Watch movie 'title'.
	 * @param title
	 * @throws IllegalStateException if the title does not exist.
	 */
	public void watch(String title) {
		if (findMovie(title) == null) {
			throw new IllegalStateException();
		}
		findMovie(title).watch();
	}
	
	/**
	 * Small example of use of the class. Does NOT necessarily cover all uses of methods specified in assignment. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		MovieRegister cb = new MovieRegister();
		cb.addMovie(new MovieKont20("Das Boot"));
		cb.watch("Das Boot");
		System.out.println("Should be 1: " + cb.findMovie("Das Boot").getTimesWatched());
		
	}

}
