package controlers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import util.Serializer;

import com.google.common.base.Optional;
import com.google.common.collect.HashBasedTable;

import models.Movie;
import models.Rating;
import models.User;
import asg.cliche.Command;
import asg.cliche.Param;

public class AdminMenu {

	public HashBasedTable<Long, Long, Rating> ratingsTable = HashBasedTable.create();
	
private String name;	//Should be used at some point
private NetflixAPI netApi;


	  public AdminMenu(NetflixAPI netApi, String userName) {

	    this.netApi = netApi;
	    this.setName(userName);
	  }
	  
	  //Name Set
	  public void setName(String name) {
	    this.name = name;
	  }
	  
				  
	 
	  
//LOAD DATA
	  @Command (description = "Load Data", abbrev = "load")// Load Data Movies / Users
		public String load() throws Exception{
				
				netApi.initialLoad();
				netApi.initialLoadRat();
				netApi.store();
			
				return "Information about users, movies and ratings loaded.";
}
				  
			
//ADD Users Movies Ratings	  
	  //One 
	  //Add a User Administrator Only
	  @Command(description = "Add a User", abbrev = "newu")
	  public void addUser(@Param(name = "first name") String firstName, 
			  				@Param(name = "last name") String lastName,
			  				@Param(name = "age") String age, 
			  				@Param(name = "gender") String gender, 
	  						@Param(name = "occupation") String occupation,
	  						@Param(name = "zip code") String zipcode,
	  						@Param(name = "role") String role)
	  {
	    netApi.createUser(firstName, lastName, age, gender, occupation,zipcode, role);
	    System.out.println("User Created:"+firstName+" "+lastName+"");
	  }
	  
	  //Two
	  //Add a Movie Administrator Only
	  @Command(description = "Add a Movie", abbrev = "newm" )
	  public void addMovie(@Param(name = "name") String title, 
			  				@Param(name = "last name") String year,
			  				@Param(name = "age") String url)
	  {
	    netApi.addMovie(title, year, url);
	  }
	  
	  
	  //Three
	  //Add Rating to a Movie Administrator Only
	  @Command(description = "Add Rating to a movie", abbrev = "addr")
	  public void addRating(@Param(name = "Movie Name") Long rat1, @Param(name = "Rating") Long rat2,
	      @Param(name = "URL") float rat3) {
	    Optional<Movie> movie = Optional.fromNullable(netApi.getMovie(rat1));
	    if (movie.isPresent()) {
	      netApi.addRating(movie.get().id, rat2, rat3);
	      System.out.println("Rating Added :)");
	    }
	  }

//GETTERS	  
	  
	  // Get User By email
	  @Command(description = "Get a User's detail", abbrev = "zip") // ****not sure what this will do****
	  public void getUser(@Param(name = "zipcode") String zipcode) {

	    User user = netApi.getUserByZip(zipcode);
	    System.out.println(user);

	  }
	  
	  	  
	  @Command(description = "Get all users sorted by their Name", abbrev= "allusers")
		public void getAllUsers() {
			TreeSet<User> sortedUsers = new TreeSet<User>();
			sortedUsers.addAll(netApi.getUsers());
			Iterator<User> iter = sortedUsers.iterator();
			while(iter.hasNext()) {
				User u = iter.next();
				System.out.println(u.firstName + " " + u.lastName+" "+u.zipcode);
			}
		}
	  
	  @Command(description="Get a List of all movies sorted by there title", abbrev = "allmovies")
		public void getMovies(){
			TreeSet<Movie> sortedMovies = new TreeSet<Movie>();
			sortedMovies.addAll(netApi.getMovies());
			Iterator<Movie> iter = sortedMovies.iterator();
			while(iter.hasNext()) {
				Movie u = iter.next();
				System.out.println(u.title +" "+ u.id);
			}
		}
	  
	  		
		public void getMovieRats(){		
		}
		
		@Command(description = "Get Movie detail", abbrev = "movie")
		  public void getMovie(@Param(name = "Movie") Long id) {
		    Movie movie = netApi.getMovie(id);
		    System.out.println(movie);
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
		
//DELETERS
		
	  //Delete User Administrator Only
	  
	  
	  @Command(description = "Delete a user(userId)", abbrev = "delUser")
		public void removeUser(@Param(name = "userId") long userId) throws Exception {
			User user = netApi.getUserId(userId);
			netApi.deleteUser(userId);
			System.out.println("\nUser: " + user.firstName + " has been deleted from the system.");
		}
	  
	  @Command(description = "Delete a movie(movieId)", abbrev = "delMov")
		public void deleteMovie(@Param(name = "movieId") long movieId) throws Exception {
			Movie movie = netApi.getMovie(movieId);
			netApi.deleteMovieId(movieId);
			System.out.println("\nMovie: " + movie.title + " has been deleted from the system.");
		}
	  
	   
	  
	  @Command(description = "Save info",abbrev= "save")
		public String save() throws Exception {
			netApi.store();
			return "You successfully saved the information.";
		}
		
	  @Command(description = "Get all ratings for a specific movie(movieId)", abbrev="gmr")
		public void getAllRatingsForMovie(@Param(name = "movieId") long movieId) {
			List<Rating> ratingsMovie = netApi.getAllRatingsForMovie(movieId);
			for (Rating rat : ratingsMovie) {
				System.out.println("The ratings are:");
				System.out.println(rat);
				
			}
		}
	  
	  @Command(description = "Average movie rating(movieId)", abbrev="avg")
		public double averageMovieRating(@Param(name = "movieID") Long movieId) {
			double average = netApi.averageMovieRating(movieId);
			return average;
		}
	  
	  @Command(description = "Top 10 movies", abbrev="top10")
		public void getTopTenMovies() {

			List<Movie> topTenMovies = netApi.getTopTenMovies();
			double score;

			for (Movie mov : topTenMovies) {
				score = netApi.averageMovieRating(mov.id);
				System.out.println(topTenMovies.indexOf(mov) + 1 + ". " + mov.title + ", Score: " + score);
			}
		}
}
