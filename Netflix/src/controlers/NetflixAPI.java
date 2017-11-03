package controlers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
	private Serializer serializer;

	public NetflixAPI() {
	}

	public void deleteMovies() {
		movieIndex.clear();

	}

	public void deleteRatings() {
		ratingIndex.clear();

	}

	public Rating addRating(String rat1, String rat2, String rat3, String rat4) {
		Rating rating = new Rating(rat1, rat2, rat3, rat4);
		ratingIndex.put(rating.id, rating);
		return rating;
	}

	public Movie addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.id, movie);
		movieIdIndex.put(title, movie);
		return movie;

	}

	public User createUser(String firstName, String lastName, String age,
			String gender, String occupation, String userid) {
		User user = new User(firstName, lastName, age, gender, occupation,
				userid);
		userIndex.put(user.id, user);
		useridIndex.put(firstName, user);
		return user;
	}

	public Collection<Movie> getMovies() {
		return movieIndex.values();
	}

	public Collection<Rating> getRatings() {
		return ratingIndex.values();
	}

	public Rating getRating(Long id) {
		return ratingIndex.get(id);
	}

	public Movie getMovie(Long id) {
		return movieIndex.get(id);
	}

	public void deleteName(String name) {
		User user = useridIndex.remove(name);
		useridIndex.remove(user.firstName);
	}

	
	public NetflixAPI(Serializer serializer) {
		this.serializer = serializer;
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		serializer.read();
		userIndex = (Map<Long, User>) serializer.pop();
		movieIndex = (Map<Long, Movie>) serializer.pop();
		ratingIndex = (Map<Long, Rating>) serializer.pop();
		// insert movie and ratings here too!!!!
	}

	void store() throws Exception {
		serializer.push(userIndex);
		serializer.push(movieIndex);
		serializer.push(ratingIndex);
		// insert movie and ratings here too!!!!
		serializer.write();
	}

	public Collection<User> getUsers() {
		return userIndex.values();
	}

	public void deleteUsers() {
		userIndex.clear();
		// useridIndex.clear();

	}

	public User getUser(Long id) {
		return userIndex.get(id);
	}

	public User getUserByUserID(String userid) {
		return useridIndex.get(userid);
	}

	public User getUserByName(String firstName) {
		return useridIndex.get(firstName);
	}

	public Movie getMovieByTitle(String title) {
		return movieIdIndex.get(title);
	}

	public void deleteUser(Long id) {
		User user = userIndex.remove(id);
		userIndex.remove(user.id); // changed useridIndex to userIndex
	}

	public void removeUser(Long userID) {
		User user = userIndex.remove(userID);
		useridIndex.remove(user.firstName);
	}

	public void deleteUser(String name) {
		User user = userIndex.remove(name);
		userIndex.remove(user.firstName);

	}

	public void initialLoad() throws IOException {
		String delims = "[|]"; // spliting the data file and spliting it at the
								// '|' sign
		Scanner scanner = new Scanner(new File("./Data/users5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) {

				createUser(userTokens[1], userTokens[2], userTokens[3],
						userTokens[4], userTokens[5], userTokens[6]);

				// System.out.println("UserID: " + userTokens[0] +
				// ", First Name: " + userTokens[1]+", Second Name: "+
				// userTokens[2]);

			} else {
				scanner.close();
				throw new IOException("Invalid member length: "
						+ userTokens.length);
			}
		}
		scanner.close();
		Scanner scanner2 = new Scanner(new File("./Data/items5.dat"));
		while (scanner2.hasNextLine()) {
			String userDetails = scanner2.nextLine();
			// parse user details string
			String[] userTokenA = userDetails.split(delims);

			if (userTokenA.length == 23) {
				// add user if you want!!
				addMovie(userTokenA[1], userTokenA[2], userTokenA[3]);
				// System.out.println("Movie Title: " + userTokens[1] +
				// " ,Year: " + userTokens[2] + " ,Url: "+ userTokens[3]);
			} else {
				scanner2.close();
				throw new IOException("Invalid member length: "
						+ userTokenA.length);
			}
		}
		scanner2.close();

		Scanner scanner3 = new Scanner(new File("./Data/ratings5.dat"));
		while (scanner3.hasNextLine()) {
			String userDetails = scanner3.nextLine();
			// parse user details string
			String[] userTokenB = userDetails.split(delims);

			if (userTokenB.length == 4) {

				// addRating(userTokenB[1], userTokenB[2], userTokenB[3],
				// userTokenB[4]);
				// add user if you want!!
				// System.out.println("Rating: " + userToken[0] +
				// " ,Movie Number: " + userToken[1]);
			} else {
				scanner3.close();
				throw new IOException("Invalid member length: "
						+ userTokenB.length);
			}
		}
		scanner3.close();
	}
}

/*
 * addUser(firstName,lastName,age,gender,occupation) removeUser(userID)
 * addMovie(title, year, url) addRating(userID, movieID, rating)
 * getMovie(movieID) getUserRatings(userID) getMoviesByTitle() getMoviesByYear()
 * initialLoad(csvFile) load() write()
 */

