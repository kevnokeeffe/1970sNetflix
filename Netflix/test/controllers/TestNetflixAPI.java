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
	      netflix.createUser(user.firstName, user.lastName, user.age, user.gender, user.occupation, user.zipcode);
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
	    assertEquals (cathrine, netflix.getUserByZip("764456G"));
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
		      User eachUser = netflix.getUserByName(cat.zipcode);
		      assertEquals (cat, eachUser);
		      assertNotSame(cat, eachUser);
		    }
	  }

	 
	  @Test
		public void testRemoveUser() throws Exception{
			assertEquals(users.length, netflix.getUsers().size());
			User kevin = netflix.createUser("Damian", "Mamak", "21", "male", "cook", "CL234", "4321");
			assertEquals(users.length+1, netflix.getUsers().size());
			netflix.removeUser(4l);
			assertEquals(users.length,netflix.getUsers().size());
		}
	  
	  @Test
		public void testUserLogin() {
			//Checking with kevin login
			assertTrue(netflix.login(users[0].id, users[0].lastName));
			assertEquals(netflix.currentUser.get(), users[0]);
			
			//check logout
			netflix.logout();
			assertEquals(netflix.currentUser, Optional.absent());
			
			//check login fail
			assertFalse(netflix.login(users[0].id, "paddy"));
			assertEquals(netflix.currentUser, Optional.absent());
			
		}
	  
	  @Test
		public void testRemoveMovie() throws Exception{
			assertEquals(movies.length, netflix.getMovies().size());
			Movie terminator = netflix.addMovie("Terminator", "1984", "http://www.imdb.com/title/tt0088247/");
			assertEquals(movies.length, netflix.getMovies().size());
			netflix.deleteMovieId(terminator);
			assertEquals(movies.length, netflix.getMovies().size());	
		}
}
	  
	  
	  
	  
	  
	  
	

