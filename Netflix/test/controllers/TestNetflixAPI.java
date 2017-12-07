package controllers;

import static org.junit.Assert.*;
import models.Movie;
import models.Rating;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Optional;

import controlers.NetflixAPI;
import static models.Fixtures.users;
import static models.Fixtures.movies;
import static models.Fixtures.ratings;




public class TestNetflixAPI {
	
	
	  private NetflixAPI netflix;

	  @Before
	  public void setup()
	  {
	    netflix = new NetflixAPI();
	    for (User user : users)
	    {
	      netflix.createUser(user.firstName, user.lastName, user.age, user.gender, user.occupation, user.userid);
	    }
	  }
	  @Before
	  public void setup2()
	  {
	    netflix = new NetflixAPI();
	    for (Movie movie : movies)
	    {
	      netflix.addMovie(movie.title, movie.year, movie.url);
	    }
	  }
	  @Before
	  public void setup3()
	  {
	    netflix = new NetflixAPI();
	    for (Rating rating : ratings)
	    {
	      netflix.addRating(rating.rat1, rating.rat2, rating.rat3);
	    }
	  }

	  @After
	  public void tearDown()
	  {
	    netflix = null;
	  }

	  @Test
	  public void testUser()
	  {
		User cathrine = new User("Cathrine", "O'Keeffe", "60", "Female", "Magic", "764456G");  
		
	    assertEquals (0, netflix.getUsers().size());
	    netflix.createUser("Cathrine", "O'Keeffe", "60", "Female", "Magic", "764456G");
	    assertEquals (cathrine, netflix.getUserByUserID("Cathrine"));
	  }  

	  @Test
	  public void testUsers()
	  {
		  netflix.createUser("Cathrine", "O'Keeffe", "60", "Female", "Magic", "764456G");
		  netflix.createUser("Cathrine", "O'Keeffe", "60", "Female", "Magic", "764456G");
		  netflix.createUser("Cathrine", "O'Keeffe", "60", "Female", "Magic", "764456G");
		  netflix.createUser("Cathrine", "O'Keeffe", "60", "Female", "Magic", "764456G");
		  assertEquals (users.length, netflix.getUsers().size());
		    for (User cat: users)
		    {
		      User eachUser = netflix.getUserByName(cat.userid);
		      assertEquals (cat, eachUser);
		      assertNotSame(cat, eachUser);
		    }
	  }

	  @Test
	  public void testDeleteUsers()
	  {
		  netflix.createUser("Kevin", "O'Keeffe", "33", "Male", "Bar Man", "7644307G");
		  netflix.createUser("Kevin", "O'Keeffe", "33", "Male", "Bar Man", "7644307G");
		  netflix.createUser("Kevin", "O'Keeffe", "33", "Male", "Bar Man", "7644307G");
		  netflix.createUser("Kevin", "O'Keeffe", "33", "Male", "Bar Man", "7644307G");
		  assertEquals (users.length, netflix.getUsers().size());
		    User Kevin = netflix.getUserByName("Kevin");
		    netflix.deleteUser(Kevin.id);
		    assertEquals (users.length-1, netflix.getUsers().size());  
		  
		  
	  }
	  /*
	  public User createUser(Long id, String fname, String lname, String age,String gender,String occupation,String userid)
	  {
	    User user = null;
	    Optional<User> users = Optional.fromNullable(userIndex.get(id));
	    if (user.isPresent())
	    {
	      user = new User ( fname, lname, age, gender, occupation, userid);
	      user.get().users.put(user.id, user);
	      userIndex.put(user.id, user);
	    }
	    return user;
	  }
	  */
}
	  
	  
	  
	  
	  
	  
	

