package controlers;

import java.util.Collection;
import java.util.Map;

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
	  
//Create User	  
	  @Command(description = "Create a new User", abbrev = "createu")
	  public void createUser(@Param(name = "first name") String firstName,
			  				 @Param(name = "last name") String lastName,
			  				 @Param(name = "age") String age, 
			  				 @Param(name = "gender") String gender,
			  				 @Param(name = "occupation") String occupation,
			  				 @Param(name = "e-mail") String userid) {

	    netApi.createUser(firstName, lastName, age, gender, occupation, userid);
	  }

	  
//LOAD DATA
			@Command // Load Data Movies / Users
			public void LoadData() throws Exception{
				
				netApi.initialLoad();
			}
			
			//Eight
			@Command //Load Ratings
			public void loadRatings() throws Exception{
				netApi.initialLoadRat();
			}
	  
			
//ADD Users Movies Ratings	  
	  //One 
	  //Add a User Administrator Only
	  @Command(description = "Add a User", abbrev = "addu")
	  public void addUser(@Param(name = "name") String firstName, 
			  				@Param(name = "last name") String lastName,
			  				@Param(name = "age") String age, 
			  				@Param(name = "gender") String gender, 
	  						@Param(name = "occupation") String occupation,
	  						@Param(name = "e-mail") String userid)
	  {
	    netApi.createUser(firstName, lastName, age, gender, occupation, userid);
	  }
	  
	  //Two
	  //Add a Movie Administrator Only
	  @Command(description = "Add a Movie", abbrev = "addm" )
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
	  @Command(description = "Get a Users detail", abbrev = "GetByEmail") // ****not sure what this will do****
	  public void getUser(@Param(name = "email") String email) {

	    User user = netApi.getUserByEmail(email);
	    System.out.println(user);

	  }
	  
	  // Get All Users
	  @Command(description = "Get all users details") 
		public void getAllUsers() {
			Collection<User> user = netApi.getUsers();
			System.out.println(user);
			
		}
	  
	  //Get Get All Users duplicate
	  @Command(description = "Get all users details")
	  public void getUsers() {
		  Collection<User> users = netApi.getUsers();
		  System.out.println(users);
	  }
	  
	  /*
	  public String getName() {
	    return name;				Note to self.. This piece of code should not be here!
	  }								Unused Method...
	  */
	  
	  // Get All Movies
	  @Command // Get All Movies
		public void getAllMovies() {
			Collection<Movie> movie = netApi.getMovies();
			System.out.println(movie);
		}
		
		
		public void getMovieRats(){		
		}
		
		// Get User By Name
		@Command 
		public void getUserByName(String fname) {
			User user = netApi.getUserByName(fname);
			System.out.println(user);
			}
		
		// Get Movie By Title
		@Command 
		public void getMovieByTitle(String title) {
			Movie movie = netApi.getMovieByTitle(title);
			System.out.println(movie);
		}	
	  
		@Command
		public void getMovieByURL(String url){
			Movie movie = netApi.getMovieByUrl(url);
			System.out.println(movie);
		}
		
		
//DELETERS
		
	  //Delete User Administrator Only
	  @Command(description = "Delete a User")
	  public void deleteUser(@Param(name = "email") String email) {

	    Optional<User> user = Optional.fromNullable(netApi.getUserByEmail(email));
	    if (user.isPresent()) {
	      netApi.deleteUser(user.get().id);
	    }
	  }
	  
	  /*
	  @Command(description = "Delete a Movie")
	  public void deleteMovie(@Param(name = "Url") String url) {

	    Optional<User> movie = Optional.fromNullable(netApi.getMovieByUrl(url));
	    if (movie.isPresent()) {
	      netApi.deleteMovie(movie.get().id);
	    }
	  }
	  */
		
		
	  
}
