package controllers;

import static org.junit.Assert.*;

import models.Fixtures;
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
	
	
	NetflixAPI netApi;
	Fixtures fixtures;
	User user;
	
	@Before
	public void setup(){
		netApi = new NetflixAPI();
		
		for(User user : users){
			netApi.createUser(user.firstName, user.lastName, user.age, user.gender, user.occupation, user.zipcode,  user.role);
		}
		
		for(Movie movie : movies){
			netApi.addMovie(movie.title, movie.year, movie.url);
		}
		for(Rating rating : ratings){
			netApi.addRating(rating.rat1, rating.rat2, rating.rat3);
		}
	}
	
	@After
	public void tearDown(){
		netApi = null;
	}
	
	
	@Test
	public void testUser(){
		assertEquals(users.length, netApi.getUsers().size());
		netApi.createUser("Heinz", "Ketchup", "69", "male", "food", "Gmbh", "admin");
		assertEquals (users.length+1, netApi.getUsers().size());	
	}
	
	@Test
	public void testMovie(){
		assertEquals(movies.length, netApi.getMovies().size());
		netApi.addMovie("Terminator", "1984", "http://www.imdb.com/title/tt0088247/");
		assertEquals(movies.length+1, netApi.getMovies().size());
	}
	
	
}	  
	  
	  
	  
	  
	

