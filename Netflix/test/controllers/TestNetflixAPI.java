package controllers;

import static org.junit.Assert.*;
import models.Movie;
import models.Rating;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	  
	  public void setup3()
	  {
	    netflix = new NetflixAPI();
	    for (Rating rating : ratings)
	    {
	      netflix.addRating(rating.rat1, rating.rat2, rating.rat3,rating.rat4);
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
	    assertEquals (users.length, netflix.getUsers().size());
	    netflix.createUser("Cathrine", "O'Keeffe", "60", "Female", "Magic", "764456G");
	    assertEquals (users.length+1, netflix.getUsers().size());
	    assertEquals (users[0], netflix.getUserByUserID(users[0].userid));
	  }  

	  @Test
	  public void testUsers()
	  {
	    assertEquals (users.length, netflix.getUsers().size());
	    for (User user: users)
	    {
	      User eachUser = netflix.getUserByUserID(user.userid);
	      assertEquals (user, eachUser);
	      assertNotSame(user, eachUser);
	    }
	  }

	  @Test
	  public void testDeleteUsers()
	  {
	    assertEquals (users.length, netflix.getUsers().size());
	    User marge = netflix.getUserByUserID("secret");
	    netflix.deleteUser(marge.id);
	    assertEquals (users.length-1, netflix.getUsers().size());    
	  }
}
	  
	  
	  
	  
	  
	  
	

