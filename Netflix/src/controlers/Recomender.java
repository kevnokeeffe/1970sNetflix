package controlers;

import java.util.Collection;
import java.util.List;

import models.Movie;
import models.Rating;
import models.User;

public class Recomender {
	

	
		
		public void load() throws Exception;
		
		public void write() throws Exception;

		public User addUser(String firstName, String surname, String age, String gender, String job, String zip, String password, String role);
		
		public void removeUser(Long userId);
		
		public Collection<User> getUsers();
		
		public User getUserById(long userId);
		
		public void prime() throws Exception;
		
		public Movie addMovie(String title, String releaseDate, String imdb);
		
		public void removeMovie(Movie movie) throws Exception;
		
		public Collection<Movie> getMovies();
		
		public Movie getMovieById(long movieId);
		
		public Collection<Movie> sortedByTitle();
		
		public List<Movie> getMovieByName(String term);
		
		public List<Movie> getTopTenMovies();
		
		public Rating addRating(long userId, long movieId, int rating);
		
		public double averageMovieRating(long movieId);
		
		public Collection<Rating> getRatings();
		
		public Rating getRating(long userId, long movieId);
		
		public List<Rating> getUserRatings(long userId);
		
		public List<Rating> getAllRatingsForMovie(long movieId);
		
		public Rating removeRating(long userId, long movieId);
		
		public void logout();
		
		public boolean login(long userId, String password);
		
	
}
