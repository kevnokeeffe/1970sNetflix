package controlers;

import java.io.File;
import java.util.Collection;
import java.util.Scanner;

import models.Movie;
import models.User;
import util.EasyScanner;
import util.Serializer;
import util.XMLSerializer;

public class Main
{
	
	public NetflixAPI netflixAPI;

	
	
	
	public Main() throws Exception {
		File movies = new File ("./Data/DataBase1.xml");
		Serializer serializer = new XMLSerializer(movies);
		netflixAPI = new NetflixAPI(serializer);
		if (movies.isFile())
			netflixAPI.load();
	}
	
	 File  datastore = new File("datastore3.xml");
	
	public static void main(String[] args) throws Exception
	  {
		Main main = new Main();
		int choice;
	    //int choice2;
	    
	    //creating variables for inputs by user;
	    String fname,lname,gender,occupation,userid,title,year,url,age; 
	   
		
		Scanner sc = new Scanner(System.in);
		
		
		//main.netflixAPI.initialLoad();
		//main.netflixAPI.store();
		main.netflixAPI.initialLoad();
		main.netflixAPI.store();
		
		System.out.println("Hello and welcome to 1970's Netflix: ");
		main.netflixAPI.store();
		do{
            System.out.println();
            System.out.println("1. List User Details");
            System.out.println("2. Enter New User");
            System.out.println("3. Enter New Movie");
            System.out.println("4. Search User by name");
            System.out.println("5. Search Movie by name");
            System.out.println("6. Delete User by ID");
            System.out.println("7. Delete Movie by URL");
            System.out.println("8. Quit");
            System.out.println();
            System.out.print("Enter choice [1-8]: ");
            
            //get choice
            choice = EasyScanner.nextInt();
            
            System.out.println();
            
            //process the menu choice
            
            switch(choice)
           
            {
                case 1:
                	
                	//Collection<User> users2 = main.netflixAPI.getUsers();
                	//System.out.println(users2);
                
             
                	
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
                    
                	main.netflixAPI.createUser(fname, lname, age, gender, occupation,userid);
                	//main.netflixAPI.store();
                	
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
                	//main.netflixAPI.store();
                	
                break;
                
                
                case 4:
                	System.out.print("Please enter first name:");
                	fname = EasyScanner.nextString();
                	Collection<User> users = main.netflixAPI.getUsers();
                	User Kev = main.netflixAPI.getUserByName(fname);
                	System.out.println(Kev);
                	
                break;
                
                case 5:
                	System.out.print("Please enter Movie name:");
                	title = EasyScanner.nextString();
                	Collection<Movie> movies = main.netflixAPI.getMovies();
                	Movie Mov = main.netflixAPI.getMovieByTitle(title);
                	System.out.println(Mov);
                break;
                	
                case 6:
                	/*System.out.print("Please enter user name:");
                	fname = EasyScanner.nextString();
                	Collection<User> users2 = main.netflixAPI.deleteUsers();
                	User Kev = main.netflixAPI.getUserByName(fname);
                	System.out.println(Kev); */
                break;
                	
                case 7:
                	
                break;
                
                case 8:
                break;
                		
                		
                default: System.out.println("Invalid entry");
                
            }
            
        }
        while(choice != 5);
		System.out.println("Thank you for using 1970's Netflix");
		
		
	    }
	  
	
}   

	
