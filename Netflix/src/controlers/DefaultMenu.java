package controlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;




import com.google.common.base.Optional;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import models.Movie;
import models.Rating;
import models.User;

public class DefaultMenu {

	
	
	
	private String name;
	  private User user;
	  private NetflixAPI netApi;

	  public DefaultMenu(NetflixAPI netApi, User user) {
	    this.netApi = netApi;
	    this.setName(user.firstName);
	    this.user = user;
	  }
	  
	  
	  @Command(description = "Get Users details", abbrev = "id")
	  public void getUserId(@Param(name = "Id") Long id) {
	    user = netApi.getUserId(id);
	    System.out.println(user);
	  }
	  
	  @Command(description = "search a user by name", abbrev = "name")
		public void getUserByName(String name) {
			ArrayList<User> user = new ArrayList<User>();
			user.addAll(netApi.getUsers());
			for(int i = 0; i < user.size(); i++) {
				if(user.get(i).firstName.toLowerCase().contains(name.toLowerCase())) {
					System.out.println(user.get(i));
				}
			}
	  }
	  
	  @Command(description = "Search a movie by name", abbrev = "title")
		public void getMovieByTitle(String title) {
			ArrayList<Movie> movie = new ArrayList<Movie>();
			movie.addAll(netApi.getMovies());
			for(int i = 0; i < movie.size(); i++) {
				if(movie.get(i).title.toLowerCase().contains(title.toLowerCase())) {
					System.out.println(movie.get(i));
				}
			}
	  }
	  
	  @Command(description = "Get Movie detail by id", abbrev = "movie")
	  public void getMovie(@Param(name = "Movie") Long id) {
	    Movie movie = netApi.getMovie(id);
	    System.out.println(movie);
	  }
	  
	  
	  @Command(description = "Add a rating", abbrev="addr")
		public void addRating(@Param(name = "userId") Long rat1, @Param(name = "movieId") Long rat2, @Param(name = "rating") Float rat3) {
			 //netApi.addRating(rat1, rat2, rat3){
				 Optional<Movie> movie = Optional.fromNullable(netApi.getMovie(rat1));
				    if (movie.isPresent()) {
				      netApi.addRating(movie.get().id, rat2, rat3);
			 }
		}
	  
	  
	  @Command(description = "Get all users sorted by their Name", abbrev= "allu")
		public void getAllUsers() {
			TreeSet<User> sortedUsers = new TreeSet<User>();
			sortedUsers.addAll(netApi.getUsers());
			Iterator<User> iter = sortedUsers.iterator();
			while(iter.hasNext()) {
				User u = iter.next();
				System.out.println(u.firstName + " " + u.lastName);
			}
		}
	
	  
	  @Command(description="Get a List of all movies sorted by there title", abbrev = "allm")
		public void getMovies(){
			TreeSet<Movie> sortedMovies = new TreeSet<Movie>();
			sortedMovies.addAll(netApi.getMovies());
			Iterator<Movie> iter = sortedMovies.iterator();
			while(iter.hasNext()) {
				Movie u = iter.next();
				System.out.println(u.title);
			}
		}
	  
	  @Command(description = "Get all ratings for a specific movie(movieId)", abbrev="gmr")
		public void getAllRatingsForMovie(@Param(name = "movieId") long movieId) {
			List<Rating> ratingsMovie = netApi.getAllRatingsForMovie(movieId);
			for (Rating rat : ratingsMovie) {
				System.out.println(rat);
			}
		}
	  
	  @Command(description = "Top 5 movies", abbrev="top5")
		public void getTopFiveMovies() {

			List<Movie> topFiveMovies = netApi.getTopTenMovies();
			double score;

			for (Movie mov : topFiveMovies) {
				score = netApi.averageMovieRating(mov.id);
				System.out.println(topFiveMovies.indexOf(mov) + 1 + ". " + mov.title + ", Score: " + score);
			}
		}
	  
	  public String getName() {
	    return name;
	  }
	  public void setName(String name) {
	    this.name = name;
	  }
	  
	  @Command (description = "Save Data", abbrev = "save")
	  public void saveData(){
		  
	  }
	
}
