package controlers;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.base.Optional;

import util.FileLogger;
import util.Serializer;
import models.Movie;
import models.Rating;
import models.User;

public class NetflixAPI {

	
	private Map<Long, User> userIndex = new HashMap<>();
	private Map<String, User> useridIndex = new HashMap<>();
	private Map<String, Movie> movieIdIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex = new HashMap<>();
	private Map<Long, Rating> ratingIndex = new HashMap<>();
//	private Map<String, Rating> ratingIdIndex = new HashMap<>();
	
	private Serializer serializer;
	Optional<User> currentUser;

	public NetflixAPI() {
	}

	// Serialize
			public NetflixAPI(Serializer serializer) {
				this.serializer = serializer;
			}
	
//RECOMEND
			/*
			public void Top10Movies()
			{
				List<Movies> list = new ArrayList<Movies>(moviesIndex.values());
				Collections.sort(list, new ComparatorByID().reversed());
				Iterator<Movies> iter = list.iterator();
				while (iter.hasNext()) {
					Movies s = iter.next();
					System.out.println(s.title + "  " + (s.ratingSum / s.rating.size()));
			}
			*/

//ADD METHODS	
	
	//Add Rating
	public void addRating(Long rat1, Long rat2, Float rat3) {
		Rating ratings = null;
		Optional<User> user = Optional.fromNullable(userIndex.get(rat1));
		Optional<Movie> movie = Optional.fromNullable(movieIndex.get(rat2));
		if(movie.isPresent()&&user.isPresent()){
			ratings = new Rating(rat1,rat2,rat3);
			movie.get().ratingM.put(ratings.id, ratings);
			user.get().rating.put(ratings.id, ratings);
			ratingIndex.put(ratings.id, ratings);
		}
	}

	
	//Add Movie
	public Movie addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.id, movie);
		movieIdIndex.put(title, movie);
		return movie;

	}

	//Add User
	public User createUser(String firstName, String lastName, String age,
			String gender, String occupation, String zipcode) {
		User user = new User(firstName, lastName, age, gender, occupation,zipcode
				);
		userIndex.put(user.id, user);
		useridIndex.put(firstName, user);
		return user;
	}
	
	//Add User Admin
	public User createUser(String firstName, String lastName, String age,
			String gender, String occupation, String zipcode,String role) {
		User user = new User(firstName, lastName, age, gender, occupation,zipcode,role
				);
		userIndex.put(user.id, user);
		useridIndex.put(firstName, user);
		return user;
	}
	
	
	
//LOGIN / LOGOUT
	
	//Login Method
	public boolean login(Long id, String lastName){
		Optional<User> user = Optional.fromNullable(userIndex.get(id));
	    if (user.isPresent() && user.get().lastName.equals(lastName)) {
	      currentUser = user;
	      FileLogger.getLogger().log(currentUser.get().firstName + " logged in...");
	      return true;
	    }
	    return false;
	}
	
	
	//Logout Method
	public void logout(){
		 Optional<User> user = currentUser;
		    if (user.isPresent()) {
		      FileLogger.getLogger().log(currentUser.get().firstName + " logged out...");
		      currentUser = Optional.absent();
		    }
		  }
	
	
//LOAD / STORE	
	
	//Load Method
	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		serializer.read();
		userIndex = (Map<Long, User>) serializer.pop();
		ratingIndex = (Map<Long, Rating>) serializer.pop();
		movieIndex = (Map<Long, Movie>) serializer.pop();
		// insert movie and ratings here too!!!!
	}

	//Store Method
	void store() throws Exception {
		
		serializer.push(movieIndex);
		serializer.push(ratingIndex);
		serializer.push(userIndex);
		// insert movie and ratings here too!!!!
		serializer.write();
	}

	
//GETTERS
	
		// Get Users collection
		public Collection<User> getUsers() {
		return userIndex.values();
		}

		//Get User
		public User getUserId(Long id) {
		return userIndex.get(id);
		}
	
		//Get Movies
		public Collection<Movie> getMovies() {
			return movieIndex.values();
		}

		//Get Ratings Collection
		public Collection<Rating> getRatings() {
			return ratingIndex.values();
		}
		
		//Get Ratings
		public Rating getRating(Long id) {
			return ratingIndex.get(id);
		}
		
		/*
		public Map<Long, Rating> getUserRating(long id) {
			Optional<User> user = Optional.fromNullable(userIndex.get(id));
			return user.get().userRatings;
		}
		
		public Map<Long, Rating> getMovieRating(long id) {
			Optional<Movie> movie = Optional.fromNullable(movieIndex.get(id));
			return movie.get().theMoviesRatings;
			
	}
*/
		//Get Movie
		public Movie getMovie(Long id) {
			return movieIndex.get(id);
		}
		
		//Get User userId
		public User getUserByZip(String zipcode) {
			return useridIndex.get(zipcode);
		}
		
		//Get User Name
		public User getUserByName(String firstName) {
			return useridIndex.get(firstName);
		}

		//Get Movie Title
		public Movie getMovieByTitle(String title) {
			return movieIdIndex.get(title);
		}		
		
		//Get Movie URL
		public Movie getMovieByUrl(String url){
			return movieIdIndex.get(url);
		}
		
//DELETERS
		
		
	//Delete Name
	public void deleteName(String name) {
		User user = useridIndex.remove(name);
		useridIndex.remove(user.firstName);
	}
		
	//Delete Users	
	public void deleteUsers() {
		userIndex.clear();
		// useridIndex.clear();
	}
	
	//Delete User Id
	public void deleteUser(Long id) {
		User user = userIndex.remove(id);
		userIndex.remove(user.id); 
	}

	//Delete User userId
	public void removeUser(Long userID) {
		User user = userIndex.remove(userID);		//This shouldn't do anything change later****
		useridIndex.remove(user.firstName);
	}

	public void deleteMovie(String url) {
		Movie movie = movieIndex.remove(url);
		movieIndex.remove(movie.url);
	}
	
	//Delete User Name
	public void deleteUser(String name) {
		User user = userIndex.remove(name);
		userIndex.remove(user.firstName);
	}

	//Delete Movies all
	public void deleteMovies() {
		movieIndex.clear();

	}
	
	//Delete Ratings All
	public void deleteRatings() {
		ratingIndex.clear();

	}
	
//GET DATA FROM FILES USERS AND MOVIES METHOD	
	
	//Load Users
	public void initialLoad() throws IOException {
		String delims = "[|]"; 
		Scanner scanner = new Scanner(new File("./Data/users5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) {
				createUser(userTokens[1], userTokens[2], userTokens[3],
						userTokens[4], userTokens[5],userTokens[6]);
			} else {
				scanner.close();
				throw new IOException("Invalid member length: "
						+ userTokens.length);
			}
		}
		scanner.close();
		
		
		// Load Movies
		Scanner scanner2 = new Scanner(new File("./Data/items5.dat"));
		while (scanner2.hasNextLine()) {
			String userDetails = scanner2.nextLine();
			String[] userTokenA = userDetails.split(delims);

			if (userTokenA.length == 23) {
			addMovie(userTokenA[1], userTokenA[2], userTokenA[3]);
				
			} else {
				scanner2.close();
				throw new IOException("Invalid member length: "
						+ userTokenA.length);
			}
		}
		scanner2.close();
	
	}

// LOAD RATINGS FROM FILE METHOD	
	
	// Load Ratings
	public void initialLoadRat() throws IOException{
			String delims = "[|]";
			Scanner scanner3 = new Scanner(new File("./Data/ratings5.dat"));
		while (scanner3.hasNextLine()) {
			String userDetails = scanner3.nextLine();
			// parse user details string
			String[] userTokenB = userDetails.split(delims);

			if (userTokenB.length == 4) {

				 addRating(Long.valueOf(userTokenB[0]),Long.valueOf(userTokenB[1]),Float.valueOf(userTokenB[2]));
				
			} else {
				scanner3.close();
				throw new IOException("Invalid member length: "
						+ userTokenB.length);
			}
		}
		scanner3.close();
	}
	
	
}
