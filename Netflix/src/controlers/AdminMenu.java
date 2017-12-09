package controlers;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import util.Serializer;

import com.google.common.base.Optional;

import models.Movie;
import models.Rating;
import models.User;
import asg.cliche.Command;
import asg.cliche.Param;

public class AdminMenu {

	
	
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
			public void LoadData() throws Exception{
				
				netApi.initialLoad();
				netApi.initialLoadRat();
				netApi.store();
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
	    }
	  }

//GETTERS	  
	  
	  // Get User By email
	  @Command(description = "Get a User's detail", abbrev = "zip") // ****not sure what this will do****
	  public void getUser(@Param(name = "email") String zipcode) {

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
				System.out.println(u.firstName + " " + u.lastName);
			}
		}
	  
	  @Command(description="Get a List of all movies sorted by there title", abbrev = "allmovies")
		public void getMovies(){
			TreeSet<Movie> sortedMovies = new TreeSet<Movie>();
			sortedMovies.addAll(netApi.getMovies());
			Iterator<Movie> iter = sortedMovies.iterator();
			while(iter.hasNext()) {
				Movie u = iter.next();
				System.out.println(u.title);
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
		
		// Get Movie By Title
		@Command 
		public void getMovieByTitle(String title) {
			Movie movie = netApi.getMovieByTitle(title);
			System.out.println(movie);
		}	
	  
		
		
//DELETERS
		
	  //Delete User Administrator Only
	  @Command(description = "Delete a User", abbrev = "delUser")
	  public void deleteUser(@Param(name = "id") String id) {

	    Optional<User> user = Optional.fromNullable(netApi.getUserByZip(id));
	    if (user.isPresent()) {
	      netApi.deleteUser(user.get().id);
	    }
	  }
	  
	  
	  @Command(description = "Delete a Movie", abbrev = "delMovie")
	  public void deleteMovie(@Param(name = "Url") String url) {

	    Optional<Movie> movie = Optional.fromNullable(netApi.getMovieByUrl(url));
	    if (movie.isPresent()) {
	      netApi.deleteMovie(movie.get().url);
	    }
	  }
	  
		
		
	  
}
