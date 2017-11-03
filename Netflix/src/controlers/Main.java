package controlers;

import java.io.File;
import java.util.Collection;
import java.util.Scanner;

import com.google.common.base.Optional;

import models.Movie;
import models.User;
import util.EasyScanner;
import util.Serializer;
import util.XMLSerializer;

public class Main {

	public NetflixAPI netflixAPI;

	public Main() throws Exception {
		File movies = new File("./Data/DataBase1.xml");
		Serializer serializer = new XMLSerializer(movies);
		netflixAPI = new NetflixAPI(serializer);
		if (movies.isFile())
			netflixAPI.load();
	}

	File datastore = new File("datastore3.xml");

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		int choice;
		// int choice2;

		// creating variables for inputs by user;
		String fname, lname, gender, occupation, userid, title, year, url, age,rat1,rat2,rat3,rat4;

		Scanner sc = new Scanner(System.in);

		main.netflixAPI.initialLoad();
		main.netflixAPI.store();
		// main.getMovieByTitle("Toy Story (1995)");

		System.out.println("Hello and welcome to 1970's Netflix: ");

		do {
			System.out.println();
			System.out.println("1. List User and Movie Details");
			System.out.println("2. Enter New User");
			System.out.println("3. Enter New Movie");
			System.out.println("4. Search User by Name");
			System.out.println("5. Search Movie by Name");
			System.out.println("6. Delete User by Name");
			System.out.println("7. Add Ratings");
			System.out.println("8. Quit");
			System.out.println();
			System.out.print("Enter choice [1-8]: ");

			// get choice
			choice = EasyScanner.nextInt();

			System.out.println();

			// process the menu choice

			switch (choice)

			{
			case 1:
				
				main.getAllMovies();
				main.getAllUsers();

				break;

			case 2:

				System.out.print("Please your first name:");
				fname = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please your second name:");
				lname = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please your age:");
				age = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please your gender:");
				gender = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please your occupation:");
				occupation = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please enter your PPS number:");
				userid = EasyScanner.nextString();
				System.out.println();

				main.netflixAPI.createUser(fname, lname, age, gender,
						occupation, userid);
				main.netflixAPI.store();

				break;

			case 3:
				System.out.print("Please enter Movie title:");
				title = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please enter Year:");
				year = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please URL:");
				url = EasyScanner.nextString();
				System.out.println();

				main.netflixAPI.addMovie(title, year, url);
				main.netflixAPI.store();

				break;

			case 4:
				System.out.print("Please enter first name:");
				fname = EasyScanner.nextString();
				main.getUserByName(fname);
				
				break;

			case 5:
				System.out.print("Please enter Movie name:");
				title = EasyScanner.nextString();
				main.getMovieByTitle(title);

				break;

			case 6:

				System.out.print("Please enter user name:");
				fname = EasyScanner.nextString();
				main.deleteUser(fname);

				break;

			case 7:
				System.out.print("Please enter Number 1:");
				rat1 = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please enter Number 2:");
				rat2 = EasyScanner.nextString();
				System.out.println();
				System.out.print("Please enter Number 3:");
				rat3 = EasyScanner.nextString();
				System.out.println();
				System.out.println("Please enter Number 4:");
				rat4 = EasyScanner.nextString();
				System.out.println();
				main.netflixAPI.addRating(rat1, rat2, rat3,rat4);
				main.netflixAPI.store();
				
				break;

			case 8:
				break;

			default:
				System.out.println("Invalid entry");

			}

		} while (choice != 8);
		System.out.println("Thank you for using 1970's Netflix");

	}

	public void getAllUsers() {
		Collection<User> user = netflixAPI.getUsers();
		System.out.println(user);
	}

	public void getAllMovies() {
		Collection<Movie> movie = netflixAPI.getMovies();
		System.out.println(movie);
	}

	public void getUserByName(String name) {
		User user = netflixAPI.getUserByName(name);
		System.out.println(user);
	}

	public void getMovieByTitle(String title) {
		Movie movie = netflixAPI.getMovieByTitle(title);
		System.out.println(movie);
	}

	public void deleteUser(String fName) {
		Optional<User> user = Optional.fromNullable(netflixAPI
				.getUserByName(fName));
		if (user.isPresent()) {
			netflixAPI.removeUser(user.get().id);
		}
	}

}
