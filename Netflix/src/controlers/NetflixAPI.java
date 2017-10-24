package controlers;

import java.util.Collection;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

//import com.google.common.base.Optional;




//import models.Activity;
//import models.Movie;
import models.User;


public class NetflixAPI {
	
	private Map<Long, User>     userIndex       = new HashMap<>();
	private Map<String, User>   useridIndex      = new HashMap<>();
	
	
	public Collection<User> getUsers ()
	  {
	    return userIndex.values();
	  }

	public  void deleteUsers() 
	  {
	    userIndex.clear();
	    useridIndex.clear();
	    
	  }

	public User createUser(String firstName, String lastName, int age, String gender, String occupation, String userid) 
	  {
	    User user = new User(firstName, lastName, age, gender, occupation, userid);
	    userIndex.put(user.id, user);
	    useridIndex.put(userid, user);
	    return user;
	  }

	public User getUser(Long id) 
	  {
	    return userIndex.get(id);
	  }

	public User getUserByEmail(String userid) 
	  {
	    return useridIndex.get(userid);
	  }
	
	  public void deleteUser(Long id) 
	  {
	    User user = userIndex.remove(id);
	    useridIndex.remove(user.userid);
	  }
	  
	  
	  
	  
	  
	  
}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	/*
	addUser(firstName,lastName,age,gender,occupation)
	removeUser(userID)
	addMovie(title, year, url)
	addRating(userID, movieID, rating)
	getMovie(movieID)
	getUserRatings(userID)
	getMoviesByTitle()
	getMoviesByYear()
	initialLoad(csvFile)
	load()
	write()
	*/
	
	

