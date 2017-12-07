package controlers;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;




import com.google.common.base.Optional;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import models.Movie;
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
	  
	  
	  @Command(description = "Get Users details", abbrev = "getu")
	  public void getUser(@Param(name = "Name") String firstName) {
	    user = netApi.getUserByName(firstName);
	    System.out.println(user);
	  }
	  
	  
	  @Command(description = "Get Movie detail", abbrev = "getm")
	  public void getMovie(@Param(name = "Movie") Long userid) {
	    Movie movie = netApi.getMovie(userid);
	    System.out.println(movie);
	  }
	  
	  
	  @Command(description = "Add a rating", abbrev="addr")
		public void addRating(@Param(name = "userId") Long rat1, @Param(name = "movieId") Long rat2, @Param(name = "rating") float rat3) {
			 netApi.addRating(rat1, rat2, rat3);
		}
	  
	  /*
	  @Command(description = "Add Rating", abbrev = "addr")
	  public void addRating(@Param(name = "Movie Name") Long rat1, @Param(name = "Rating") Long rat2,
	      @Param(name = "URL") float rat3) {
	    Optional<Movie> movie = Optional.fromNullable(netApi.getMovie(rat1));
	    if (movie.isPresent()) {
	      netApi.addRating(movie.get().id, rat2, rat3);
	    }
	  }
	  */
	  @Command(description = "Get all users sorted by there Name", abbrev= "allu")
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
