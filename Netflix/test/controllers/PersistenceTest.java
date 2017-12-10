package controllers;





	import static org.junit.Assert.*;
	import org.junit.Test;

import controlers.NetflixAPI;
import models.Movie;
	import models.User;
	import models.Rating;
	import static models.Fixtures.users;
	import static models.Fixtures.movies;
	import static models.Fixtures.ratings;

	// JUnit test case for testing the persistence of the application
	public class PersistenceTest {

		NetflixAPI netApi;
		
		void generate(NetflixAPI netApi){
			for(User user : users){
				netApi.createUser(user.firstName, user.lastName, user.age, user.gender, user.occupation, user.zipcode, user.role);
			}
			for(Movie movie : movies){
				netApi.addMovie(movie.title, movie.year, movie.url);
			}
			for(Rating rating : ratings){
				netApi.addRating(rating.rat1, rating.rat2, rating.rat3);
			}
		}
		
		@Test
		public void testEmpty(){
			netApi = new NetflixAPI(null);
			assertEquals(0, netApi.movieIndex.size());
			assertEquals(0, netApi.ratingsTable.size());
			assertEquals(0, netApi.userIndex.size());
			generate(netApi);
		}
		
		

	}

