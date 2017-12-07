package util;

import java.util.Comparator;
import models.Movie;

public class ComparatorByID implements Comparator<Movie> {
	@Override
	public int compare(Movie s1, Movie s2) {
		
		return (int) (s1.ratingSum - s2.ratingSum);
	}

}